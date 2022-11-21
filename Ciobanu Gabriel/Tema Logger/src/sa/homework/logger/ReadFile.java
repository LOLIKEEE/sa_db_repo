package sa.homework.logger;

import org.jetbrains.annotations.NotNull;
import sa.homework.logger.enums.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile implements IFile {
    private static List<File> getAllFiles() {
        File file = new File(FILE_PATH);
        try {
            return Arrays.asList(Objects.requireNonNull(file.listFiles()));
        } catch (NullPointerException e) {
            System.out.println("No files Founded");
            return null;
        }
    }

    public static List<LogItem> readLogs(@NotNull Level level) {
        return null;
    }

    public static List<LogItem> getAllLogs() {
        List<LogItem> logList = new ArrayList<>();
        List<String> logAsStringList = readFiles();

        for (String logAsString : logAsStringList){
            logList.add(LogItem.parseLog(logAsString));
        }

        return logList;
    }

    private static List<String> readFiles() {
        //de implementat si prin aceasta metoda
        //Files.readAllLines(Path.of(FILE_PATH))
        List<File> files = getAllFiles();
        List<String> logs = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNext()) {
                        logs.add(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found!");
                }

            }
        }


        return logs;
    }
}
