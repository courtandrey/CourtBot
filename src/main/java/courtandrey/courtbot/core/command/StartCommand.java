package courtandrey.courtbot.core.command;

import courtandrey.courtbot.core.bot.ReplyKeyboardMaker;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand extends BaseCourtCommand{

    public StartCommand(String description) {
        super(Command.START.getName(), description);
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Hello!");
        sendMessage.setReplyMarkup((new ReplyKeyboardMaker()).getMainMenuKeyboard());
        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.error(e.getLocalizedMessage());
        }
    }
}
