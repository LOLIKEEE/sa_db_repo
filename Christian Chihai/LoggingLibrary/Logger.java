import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final Logger logger;
    private static Destination dest;
    private static File myFile;

    static {
        logger = new Logger();
    }
    private Logger() {
        dest = Destination.CONSOLE;
        myFile = null;
    }
    public static Logger getInstance() {
        return logger;
    }

    public void info(String message) {
        printLogItem(Level.INFO, message);
    }

    public void debug(String message) {
        printLogItem(Level.DEBUG, message);
    }

    public void warn(String message) {
        printLogItem(Level.WARN, message);
    }

    public void error(String message) {
        printLogItem(Level.ERROR, message);
    }

    public void fatal(String message) {
        printLogItem(Level.FATAL, message);
    }

    private String getFileNameBasedOnDate() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyyHHmmss").format(LocalDateTime.now()).toString();
    }

    // If destination is set to file and no file name is provided we create a file with current datetime as name
    public void setDestination(Destination dest) {
        if(dest == Destination.CONSOLE)
            this.dest = Destination.CONSOLE;
        else {
            setDestination(Destination.FILE, getFileNameBasedOnDate());
        }
    }

    public void setDestination(Destination dest, String fileName) {
        myFile = new File(fileName);
        this.dest = Destination.FILE;
    }


    private boolean checkFileSize() throws IOException {
        if(Files.size(Paths.get(myFile.getAbsolutePath())) < 5000000)
            return true;
        return false;
    }

    private void printLogItem(Level level, String message) {
        switch(dest) {
            case FILE : {
                try {
                    if(myFile != null && !myFile.createNewFile()) // if a file with specified name exists
                        if(!checkFileSize()) // checks for limit in size, if limit exceeded we crete a new file with current datetime as filename
                            myFile = new File(DateTimeFormatter.ofPattern("dd-MM-yyyyHHmmdd").format(LocalDateTime.now()).toString());

                    //write logs to file
                    FileWriter writer = new FileWriter(myFile,true);
                    writer.write(new LoggerItem(level, message).toString()+"\n");
                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            case CONSOLE : {
                System.out.println(new LoggerItem(level, message));
                break;
            }
        }
    }

    public void printAllLogs() throws IOException, NullPointerException{
        Files.lines(Paths.get(myFile.getAbsolutePath())).forEach(System.out::println);
    }

    public List<LoggerItem> getAllLogs(String date) throws IOException, NullPointerException {
        List<LoggerItem> loggerItems = new ArrayList<>();
        Files.lines(Paths.get(myFile.getAbsolutePath()))
                .filter(r -> r.contains(date))
                .forEach(a -> {
                    String[] context = a.toString().split("\\-\\:\\:\\-");
                    loggerItems.add(new LoggerItem(Instant.parse(context[0]), Level.valueOf(context[1]), context[2]));
                });
        return loggerItems;
    }

    public List<LoggerItem> getAllLogs(Level level) throws IOException, NullPointerException {
        List<LoggerItem> loggerItems = new ArrayList<>();
        Files.lines(Paths.get(myFile.getAbsolutePath()))
                .filter(r -> r.contains(level.toString()))
                .forEach(a -> {
                    String[] context = a.toString().split("\\-\\:\\:\\-");
                    loggerItems.add(new LoggerItem(Instant.parse(context[0]), Level.valueOf(context[1]), context[2]));
                });
        return loggerItems;
    }
}
