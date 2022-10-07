package courtandrey.courtbot.core.command;

public enum Command {
    HELP("/help"),
    SHOW_DECISION("/show_decision"),
    START("/start");

    final String BUTTON_NAME;

    Command(String BUTTON_NAME) {
        this.BUTTON_NAME = BUTTON_NAME;
    }

    public static boolean isCommand(String text) {
        for (Command command:Command.values()) {
            if (command.getButtonName().equals(text)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDialogCommand(String text) {
        if (text.equals(SHOW_DECISION.BUTTON_NAME)) {
            return true;
        }
        return false;
    }

    public static Command parseCommand(String text) {
        for (Command command:Command.values()) {
            if (command.getButtonName().equals(text)) {
                return command;
            }
        }
        return null;
    }

    public String getName() {
        return BUTTON_NAME.replace("/", "");
    }

    public String getButtonName() {
        return BUTTON_NAME;
    }
}
