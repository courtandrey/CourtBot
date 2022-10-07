package courtandrey.courtbot.core.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.simple.SimpleLogger;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

abstract class BaseCourtCommand implements IBotCommand {
    protected static Logger logger = LoggerFactory.getLogger(SimpleLogger.class);
    final String identifier;
    final String description;
    BaseCourtCommand(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    @Override
    public String getCommandIdentifier() {
        return identifier;
    }

    @Override
    public String getDescription() {
        return description;
    }


    void sendAnswer(AbsSender absSender, String text, Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        try {
            message.setText(text);
            absSender.execute(message);
        } catch (TelegramApiException e) {
            logger.warn(String.format("Exception %s occurred while executing %s", e.getLocalizedMessage(), identifier));
        }
    }
}
