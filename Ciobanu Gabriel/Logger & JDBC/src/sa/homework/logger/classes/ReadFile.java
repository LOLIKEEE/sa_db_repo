package sa.homework.logger.classes;

import sa.homework.resources.config.MyProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    private static List<File> getAllFiles() {
        File file = new File(MyProperties.getFilePath());
        try {
            return Arrays.asList(Objects.requireNonNull(file.listFiles()));
        } catch (NullPointerException e) {
            System.out.println("No files Found");
            return null;
        }
    }

    public static List<LogItem> getAllLogs() {
        List<LogItem> logList = new ArrayList<>();
        List<String> logAsStringList = readFiles();

        for (String logAsString : logAsStringList) {
            logList.add(LogItem.parseLog(logAsString));
        }

        return logList;
    }

    private static List<String> readFiles() {
        List<File> files = getAllFiles();
        List<String> logs = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        if (line.length() > 30) {
                            logs.add(line);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found!");
                }
            }
        }

        return logs;
    }
}
