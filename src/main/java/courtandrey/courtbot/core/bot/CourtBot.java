package courtandrey.courtbot.core.bot;

import courtandrey.courtbot.core.command.Command;
import courtandrey.courtbot.core.command.HelpCommand;
import courtandrey.courtbot.core.command.ShowDecisionCommand;
import courtandrey.courtbot.core.command.StartCommand;
import courtandrey.courtbot.core.service.MessageSender;
import courtandrey.courtbot.task.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

@Component
public class CourtBot extends TelegramLongPollingCommandBot {
    @Value("${BOT_NAME}")
    private String BOT_USERNAME;
    @Value("${BOT_TOKEN}")
    private String BOT_TOKEN;
    @Autowired
    private TaskManager taskManager;
    @Autowired
    private SessionController controller;

    public CourtBot() {
        register(new HelpCommand("Shows info about bot"));
        register(new ShowDecisionCommand("Shows court decision"));
        register(new StartCommand("Initializes bot"));
    }

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        controller.changeSessions(updates);
        super.onUpdatesReceived(updates);
    }

    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        try {
            Command command = controller.checkDialog(update);
            SendMessage info = new SendMessage();
            info.setChatId(update.getMessage().getChatId());
            info.setText("It may take some time...");
            execute(info);
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId());
            if (command != null) {
                String response;
                response = taskManager.execute(command, update.getMessage().getText());
                List<SendMessage> messages = MessageSender.sendMessage(update.getMessage().getChatId(), response);
                messages.forEach(x -> {
                    try {
                        execute(x);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                });
                return;
            }
            message.setText("This is not a supported command");
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
