package courtandrey.courtbot.core.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;

public final class MessageSender {
    public static List<SendMessage> sendMessage(Long chatId, String text) {
        List<SendMessage> messages = new ArrayList<>();
        if (text.length() > 900) {
            while (text.length() > 900) {
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText(text.substring(0, 900));
                text = text.substring(900);
                messages.add(message);
            }
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(text);
            messages.add(message);
        } else  {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(text);
            messages.add(message);
        }
        return messages;
    }
}