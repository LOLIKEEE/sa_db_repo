package sa.homework.logger.classes;

import sa.homework.logger.enums.Level;
import sa.homework.logger.enums.TextColor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LogItem {
    private LocalDateTime dateTime;
    private Level level;
    private String message;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss.SSS");


    public LogItem(Level level, String message, LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.level = level;
        this.message = message;
    }

    public LogItem() {
    }

    @Override
    public String toString() {
        return dateTime.format(DATE_TIME_FORMATTER) + " " + level + " -> " +
                message + "\n";
    }

    //unsafe because the method depend of a static index
    public static LogItem parseLog(String s) {
        return new LogItem(Level.toLevel(s.substring(25, 30).trim()), s.substring(33),
                toLocalDateTime(s.substring(0, 24).trim()));
    }

    private static LocalDateTime toLocalDateTime(String s) {
        return LocalDateTime.parse(s, DATE_TIME_FORMATTER);
    }

    public void print() {
        switch (level) {
            case INFO:
                System.out.println(TextColor.GREEN.getColor() + dateTime.format(DATE_TIME_FORMATTER) + " " + level + " -> " +
                        message + "\n" + TextColor.RESET.getColor());
                break;
            case DEBUG:
                System.out.println(TextColor.BLUE.getColor() + dateTime.format(DATE_TIME_FORMATTER) + " " + level + " -> " +
                        message + "\n" + TextColor.RESET.getColor());
                break;
            case WARN:
                System.out.println(TextColor.PURPLE.getColor() + dateTime.format(DATE_TIME_FORMATTER) + " " + level + " -> " +
                        message + "\n" + TextColor.RESET.getColor());
                break;
            case ERROR:
                System.out.println(TextColor.YELLOW.getColor() + dateTime.format(DATE_TIME_FORMATTER) + " " + level + " -> " +
                        message + "\n" + TextColor.RESET.getColor());
                break;
            case FATAL:
                System.out.println(TextColor.RED.getColor() + dateTime.format(DATE_TIME_FORMATTER) + " " + level + " -> " +
                        message + "\n" + TextColor.RESET.getColor());
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}