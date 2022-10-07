package courtandrey.courtbot.task;

import java.util.concurrent.Callable;

public class GetRandomDecisionMatchingTextTask implements Callable<String> {
    private String phrase;

    public GetRandomDecisionMatchingTextTask(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String call() {
        return "Here's your decision!";
    }
}
