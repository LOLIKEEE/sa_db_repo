
public class Main {



    public static void main(String[] args) {

        ReadFile readFile = new ReadFile();
        Destinaton destinaton = new Destinaton();
        destinaton.logDestination(Destinaton.DestinationEnum.CONSOLE);
        destinaton.logDestination(Destinaton.DestinationEnum.CONSOLE_AND_LOGFILE);
        destinaton.logDestination(Destinaton.DestinationEnum.LOGFILE);
        readFile.getSpecificLog("2022-12-15");

    }
}