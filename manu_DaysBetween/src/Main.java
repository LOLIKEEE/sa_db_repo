import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Main {

        public static void main(String[] args) {

            LocalDateTime time1 = LocalDateTime.of(
                    2000, Month.APRIL, 24, 1, 1);
            LocalDateTime time2 = LocalDateTime.of(
                    2021, 5, 22, 1, 1);

            System.out.println( "number of days = " + getNumberOfDaysBetween(time1, time2)) ;

        }



    public static long getNumberOfDaysBetween(LocalDateTime firstDate, LocalDateTime secondDate){

            long printDays = ChronoUnit.DAYS.between(firstDate,secondDate);
            System.out.println("first date -> " + firstDate + '\n'  + "second date -> " + secondDate);


    return  printDays;
}
}