package courtandrey.courtbot.core.command;

import courtandrey.courtbot.core.service.ResourceRetriever;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class HelpCommand extends BaseCourtCommand{
    private static final String HELP_MESSAGE = ResourceRetriever.retrieve("help.txt");
    public HelpCommand(String description) {
        super(Command.HELP.getName(), description);
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        sendAnswer(absSender, HELP_MESSAGE, message.getChatId());
    }
}
