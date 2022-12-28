import java.time.LocalDateTime;

public class LogItem {
    static LoggerMessage loggerMessage = new LoggerMessage();

    static String messageInfo = LocalDateTime.now() + " " + LogLevel.INFO + " " + loggerMessage.getInfo() + "\n";
    static String messageWarn = LocalDateTime.now() + " " + LogLevel.WARN + " " + loggerMessage.getWarn() + "\n";
    static String messageDebug = LocalDateTime.now() + " " + LogLevel.DEBUG + " " + loggerMessage.getDebug() + "\n";
    static String messageError = LocalDateTime.now() + " " + LogLevel.ERROR + " " + loggerMessage.getError() + "\n";
    static String messageFatal = LocalDateTime.now() + " " + LogLevel.FATAL + " " + loggerMessage.getFatal() + "\n";


}