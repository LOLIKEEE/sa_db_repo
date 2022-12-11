import java.time.Instant;

public class LoggerItem {
    private Instant dateTime;
    private Level level;
    private String message;

    public LoggerItem(Level level, String message) {
        dateTime = Instant.now();
        this.level = level;
        this.message = message;
    }

    public LoggerItem(Instant instant, Level level, String message) {
        this.dateTime = instant;
        this.level = level;
        this.message = message;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return dateTime + "-::-" + level + "-::-" + message;
    }
}
