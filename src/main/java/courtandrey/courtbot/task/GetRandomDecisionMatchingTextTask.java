package courtandrey.courtbot.task;

import courtandrey.pravosudieapi.Pravosudie;

import java.util.concurrent.Callable;

public class GetRandomDecisionMatchingTextTask implements Callable<String> {
    private final String phrase;

    public GetRandomDecisionMatchingTextTask(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String call() {
        Pravosudie pravosudie = new Pravosudie();
        return pravosudie.retrieveRandomDecisionMatchingText(phrase).getText();
    }


}
