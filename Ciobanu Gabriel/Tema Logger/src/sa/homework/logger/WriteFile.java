package sa.homework.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile implements IFile{

    private static final long MEGA_BYTE = 1024 * 1024;

    // File Counter
    private static int fileCounter = 1;
    //private static int infoFileCounter = 1;
    //private static int warnFileCounter = 1;
    //private static int errorFileCounter = 1;
    //private static int fatalFileCounter = 1;

    //Current Filename
    private static String currentFileName = FILE_NAME + fileCounter + EXTENSION;
    //private static String currentInfoFile = "info" + infoFileCounter + EXTENSION;
    //private static String currentWarnFile = "warn" + warnFileCounter + EXTENSION;
    //private static String currentErrorFile = "error" + errorFileCounter + EXTENSION;
   // private static String currentFatalFile = "fatal" + fatalFileCounter + EXTENSION;

    public static void writeLog(LogItem logItem) {

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
                currentFileName = FILE_NAME+ fileCounter + EXTENSION;
            }
        } while (true);
    }

//    public static void writeLogInfo(String message) {
//
//        createInfoFile();
//
//        if (writeFile(currentInfoFile, message)) {
//            System.out.println("Message was write in file.");
//        } else {
//            System.out.println("Failed to write");
//        }
//    }
//
//    private static void createInfoFile() {
//        do {
//            if (createFile(currentInfoFile)) {
//                break;
//            } else {
//                infoFileCounter++;
//                currentInfoFile = "Info" + infoFileCounter + EXTENSION;
//            }
//        } while (true);
//    }
//
//    public static void writeLogWarn(String message) {
//
//        createWarnFile();
//
//        if (writeFile(currentWarnFile, message)) {
//            System.out.println("Message was write in file.");
//        } else {
//            System.out.println("Failed to write");
//        }
//    }
//
//    private static void createWarnFile() {
//        do {
//            if (createFile(currentWarnFile)) {
//                break;
//            } else {
//                warnFileCounter++;
//                currentWarnFile = "warn" + warnFileCounter + EXTENSION;
//            }
//        } while (true);
//    }
//
//    public static void writeLogError(String message) {
//
//        createErrorFile();
//
//        if (writeFile(currentErrorFile, message)) {
//            System.out.println("Message was write in file.");
//        } else {
//            System.out.println("Failed to write");
//        }
//    }
//
//    private static void createErrorFile() {
//        do {
//            if (createFile(currentErrorFile)) {
//                break;
//            } else {
//                errorFileCounter++;
//                currentErrorFile = "error" + errorFileCounter + EXTENSION;
//            }
//        } while (true);
//    }
//
//    public static void writeLogFatal(String message) {
//
//        createFatalFile();
//
//        if (writeFile(currentFatalFile, message)) {
//            System.out.println("Message was write in file.");
//        } else {
//            System.out.println("Failed to write");
//        }
//    }
//
//    private static void createFatalFile() {
//        do {
//            if (createFile(currentFatalFile)) {
//                break;
//            } else {
//                fatalFileCounter++;
//                currentFatalFile = "fatal" + fatalFileCounter + EXTENSION;
//            }
//        } while (true);
//    }

    private static boolean writeFile(String fileName, String message) {
        File file = new File(FILE_PATH + fileName);
        if (file.canWrite()) {
            try {
                FileWriter myWriter = new FileWriter(file, true);
                myWriter.write(message);
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean newFile(String fileName) {
        try {

            File myFile = new File(FILE_PATH + fileName);
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

    private static boolean checkFileSize( File file) {

        double fileLength = (double) file.length() / MEGA_BYTE;

        return !(fileLength > 5);
    }
}
