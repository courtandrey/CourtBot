package courtandrey.courtbot.core.command;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class ShowDecisionCommand extends BaseCourtCommand{
    public ShowDecisionCommand(String description) {
        super(Command.SHOW_DECISION.getName(), description);
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        sendAnswer(absSender, "Write the phrase you are looking for:", message.getChatId());
    }
}
