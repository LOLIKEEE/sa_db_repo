package sa.homework.logger.classes;

import sa.homework.resources.config.MyProperties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private static final long MEGA_BYTE = 1024 * 1024;

    // File Counter
    private static int fileCounter = 1;

    //Current Filename
    private static String currentFileName = MyProperties.getFileName() + fileCounter + MyProperties.getFileExtension();


    public static void writeLog(final LogItem logItem) {

        createFile();

        if (writeFile(currentFileName, logItem.toString())) {
            System.out.println("Message was write in file.");
        } else {
            System.out.println("Failed to write");
        }
    }


    private static void createFile() {
        do {
            if (newFile(currentFileName)) {
                break;
            } else {
                fileCounter++;
                currentFileName = MyProperties.getFileName() + fileCounter + MyProperties.getFileExtension();
            }
        } while (true);
    }

    private static boolean writeFile(final String fileName, final String message) {
        File file = new File(MyProperties.getFilePath() + fileName);
        if (file.canWrite()) {
            try (FileWriter myWriter = new FileWriter(file, true)) {
                myWriter.write(message);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean newFile(final String fileName) {
        try {

            File myFile = new File(MyProperties.getFilePath() + fileName);
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
                return true;
            } else {
                return checkFileSize(myFile);

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    private static boolean checkFileSize(final File file) {

        double fileLength = (double) file.length() / MEGA_BYTE;

        return !(fileLength > 5);
    }
}
