package pravosudieapi;

public class Pravosudie {
    private final pravosudieapi.Scraper scraper;

    public Pravosudie() {
        scraper = new Scraper();
    }

    public Decision retrieveRandomDecisionMatchingText(String text) throws PravosudieApiException {
        try {
            scraper.manageRequest().setText(text);
            return scraper.getRandomDecision();
        } catch (Exception e) {
            throw new PravosudieApiException();
        }
    }
}