package courtandrey.courtbot.task;

import courtandrey.courtbot.core.command.Command;
import courtandrey.pravosudieapi.PravosudieApiException;
import org.springframework.stereotype.Component;

@Component
public class TaskManager {
    public String execute(Command command, String... args) {
        switch (command) {
            case SHOW_DECISION -> {
                String response;
                try {
                    response = (new GetRandomDecisionMatchingTextTask(args[0])).call();
                } catch (PravosudieApiException e) {
                    response = "Sorry, error occurred while retrieving";
                }
                if (response == null) {
                    response = "Nothing found for your request :(";
                }
                return response;
            }
            default -> {
                return null;
            }
        }
    }
}
