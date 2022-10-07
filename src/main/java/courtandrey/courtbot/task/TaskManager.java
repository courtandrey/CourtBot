package courtandrey.courtbot.task;

import courtandrey.courtbot.core.command.Command;
import org.springframework.stereotype.Component;

@Component
public class TaskManager {
    public String execute(Command command, String... args) {
        switch (command) {
            case SHOW_DECISION -> {
                return (new GetRandomDecisionMatchingTextTask(args[0])).call();
            }
            default -> {
                return null;
            }
        }
    }
}
