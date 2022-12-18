package sa.homework.logger.enums;

public enum Level {
    INFO,
    DEBUG,
    WARN,
    ERROR,
    FATAL;
    public static Level toLevel(final String s){
        switch (s) {
            case "INFO":
                return INFO;
            case "DEBUG":
                return DEBUG;
            case "WARN":
                return WARN;
            case "ERROR":
                return ERROR;
            case "FATAL":
                return FATAL;
            default:
                return null;
        }
    }
}
