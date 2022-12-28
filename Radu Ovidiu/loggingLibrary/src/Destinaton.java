public class Destinaton {
    public enum DestinationEnum {
        CONSOLE,
        LOGFILE,
        CONSOLE_AND_LOGFILE
    }
    LogItem logItem = new LogItem();
    WriteToFile write = new WriteToFile();
        public void logDestination(DestinationEnum d) {
        switch (d){
            case CONSOLE:
                printMessage();
                break;
            case LOGFILE:
                writeToFile();
                break;
            case CONSOLE_AND_LOGFILE:
                printMessage();
                writeToFile();
        }
    }
    private void printMessage(){
        System.out.println(logItem.messageInfo
                + logItem.messageWarn + logItem.messageDebug + logItem.messageError + logItem.messageFatal );
    }
    private void writeToFile(){
        write.writeInfoLog();
        write.writeWarnLog();
        write.writeDebugLog();
        write.writeErrorLog();
        write.writeFatalLog();
    }
}
