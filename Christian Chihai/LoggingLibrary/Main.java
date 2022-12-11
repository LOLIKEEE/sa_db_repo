import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setDestination(Destination.FILE, "logsFile.log");

        logger.info("This is a info log");
        logger.warn("This is a warn log");
        logger.fatal("This is a fatal log");
        logger.info("This is another info log");

        try {
            List<LoggerItem> items = logger.getAllLogs(Level.INFO);
            if(!items.isEmpty())
                for(LoggerItem item : items)
                    System.out.println(item);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}