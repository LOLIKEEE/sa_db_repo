
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class NumberOfDaysBetween {


    public static void main(String[] args) {
        LocalDateTime newFirstDate = LocalDateTime.of(2021, Month.SEPTEMBER,1,10,10);
        LocalDateTime newSecondDate = LocalDateTime.of(2022,Month.SEPTEMBER,22,22,22);

        System.out.println("Number of days between first and second date is: " + getNumberOfDaysBetween(newFirstDate,newSecondDate));
    }


   public static int getNumberOfDaysBetween( LocalDateTime firstDate,LocalDateTime secondDate){
        
        return (int) ChronoUnit.DAYS.between(firstDate,secondDate);

    }
}