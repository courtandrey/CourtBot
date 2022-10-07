package courtandrey.courtbot.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class CourtBot extends TelegramLongPollingBot {
    @Value("${BOT_NAME}")
    private String BOT_USERNAME;
    @Value("${BOT_TOKEN}")
    private String BOT_TOKEN;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId());
            message.setText("Тмок");
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    public String getBotToken() {
        return BOT_TOKEN;
    }
}
