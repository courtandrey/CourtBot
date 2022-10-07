package courtandrey.courtbot;

import courtandrey.courtbot.core.CourtBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

public class CourtBotApplication {
    private static final Map<String, String> getenv = System.getenv();
    public static void main(String[] args) {
     try {
         TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
         botsApi.registerBot(new CourtBot(getenv.get("BOT_NAME"), getenv.get("BOT_TOKEN")));
     } catch (TelegramApiException e) {
         throw new RuntimeException(e);
     }
    }
}
