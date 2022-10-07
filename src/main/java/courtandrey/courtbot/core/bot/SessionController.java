package courtandrey.courtbot.core.bot;

import courtandrey.courtbot.core.command.Command;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
@Component
class SessionController {
    private final Map<Long, Session> sessions = new HashMap<>();

    static class Session{
        volatile LinkedList<String> commands = new LinkedList<>();
    }

    void changeSessions(List<Update> updates) {
        for (Update update:updates) {
            if (sessions.containsKey(update.getMessage().getChatId())) {
                addCommand(update);
            }
            else {
                sessions.put(update.getMessage().getChatId(), new Session());
            }
        }
    }

    Command checkDialog(Update update) {
        String commandText = sessions.get(update.getMessage().getChatId()).commands.peekLast();
        if (commandText == null) return null;
        if (Command.isDialogCommand(commandText)) {
            sessions.get(update.getMessage().getChatId()).commands.clear();
            return Command.parseCommand(commandText);
        }
        return null;
    }

    private void addCommand(Update update) {
        if (Command.isCommand(update.getMessage().getText())) {
            sessions.get(update.getMessage().getChatId()).commands.add(update.getMessage().getText());
        }
    }
}
