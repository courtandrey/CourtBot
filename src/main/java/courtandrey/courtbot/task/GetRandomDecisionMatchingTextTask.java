package courtandrey.courtbot.task;

import courtandrey.pravosudieapi.Pravosudie;
import courtandrey.pravosudieapi.PravosudieApiException;

import java.util.concurrent.Callable;

public class GetRandomDecisionMatchingTextTask implements Callable<String> {
    private final String phrase;

    public GetRandomDecisionMatchingTextTask(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String call() throws PravosudieApiException {
        return (new Pravosudie()).retrieveRandomDecisionMatchingText(phrase).getText();
    }


}
