package courtandrey.courtbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class CourtBotApplication {
    public static void main(String[] args) {
     try {
         new TelegramBotsApi(DefaultBotSession.class);
         SpringApplication.run(CourtBotApplication.class, args);
     } catch (TelegramApiException e) {
         throw new RuntimeException(e);
     }
    }
}
