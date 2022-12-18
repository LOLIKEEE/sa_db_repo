import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class ReadFile {

    public static List<String> readFileInList(String fileName) {
        List<String> lines = new ArrayList<>();
        try
        {
             lines = Files.readAllLines(Paths.get(fileName));
        }
        catch (IOException e)
        {
            System.out.println("something happend");
            e.printStackTrace();
        }
        return lines;
 }


    public void getAllLogs() {
        List l = ReadFile.readFileInList("logFile.txt");

        Iterator<String> itr = l.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }
    public void getSpecificLog(String date) {
        try {
            List<String> specificList = Files.readAllLines(Paths.get("logFile.txt"));
            for(String element:specificList){
                if(element.startsWith(date)){
                    System.out.println(element);
                }
            }

        }catch (IOException e){
            System.out.println("No function found");
            e.printStackTrace();
        }

    }
    
}

