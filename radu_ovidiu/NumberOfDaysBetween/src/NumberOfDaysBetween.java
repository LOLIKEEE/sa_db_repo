
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class NumberOfDaysBetween {

    static LocalDateTime newFirstDate = LocalDateTime.of(2021, Month.SEPTEMBER,1,10,10);
    static LocalDateTime newSecondDate = LocalDateTime.of(2022,Month.SEPTEMBER,22,22,22);

    public static void main(String[] args) {

        System.out.println("Number of days between first and second date is: " + getNumberOfDaysBetween(newFirstDate,newSecondDate));
    }

   public static int getNumberOfDaysBetween( LocalDateTime firstDate,LocalDateTime secondDate){

        return (int) ChronoUnit.DAYS.between(firstDate,secondDate);
    }
}