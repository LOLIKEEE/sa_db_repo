import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteToFile {

    private static  String logFile = "logFile";
    private static  int maxFileSize = 50000;

    private static LogItem logger = new LogItem();




     String writeInfoLog() {
        try {
                File file = new File(logFile + ".txt");
                int i = 0;
                if(file.length()>maxFileSize){

                    file = new File(logFile + String.valueOf(i++)+".txt");
                }

            BufferedWriter outputWritter = new BufferedWriter(new FileWriter(file, true),maxFileSize);
            outputWritter.write(logger.messageInfo);
            outputWritter.close();

        } catch (
                IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
         return logger.messageInfo;
     }
     String  writeWarnLog() {
        try {


            File file = new File(logFile + ".txt");
            int i = 0;
            if(file.length()>maxFileSize){
                file = new File(logFile + String.valueOf(i++)+".txt");
            }

            BufferedWriter outputWritter = new BufferedWriter(new FileWriter(file, true));
            outputWritter.write(logger.messageWarn);
            outputWritter.close();

        } catch (
                IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return logger.messageWarn;
    }
   String writeDebugLog() {
        try {

            File file = new File(logFile + ".txt");
            int i = 0;
            if(file.length()>maxFileSize){
                file = new File(logFile + String.valueOf(i++)+".txt");
            }

            BufferedWriter outputWritter = new BufferedWriter(new FileWriter(file, true));
            outputWritter.write(logger.messageDebug);
            outputWritter.close();

        } catch (
                IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
       return logger.messageDebug;
   }
    String writeErrorLog() {
        try {

            File file = new File(logFile + ".txt");
            int i = 0;
            if(file.length()>maxFileSize){
                file = new File(logFile + String.valueOf(i++)+".txt");
            }

            BufferedWriter outputWritter = new BufferedWriter(new FileWriter(file, true));
            outputWritter.write(logger.messageError);
            outputWritter.close();

        } catch (
                IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return logger.messageError;
    }
    String writeFatalLog() {
        try {

            File file = new File(logFile + ".txt");
            int i = 0;
            if(file.length()>maxFileSize){
                file = new File(logFile + String.valueOf(i++)+".txt");
            }
            BufferedWriter outputWritter = new BufferedWriter(new FileWriter(file, true));
            outputWritter.write(logger.messageFatal);
            outputWritter.close();

        } catch (
                IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
         return logger.messageFatal;
     }


}
