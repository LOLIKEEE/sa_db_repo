import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Date format is: YYYY-MM-DD");
        System.out.println("Number of days between first and second dates is:  " + getNumberOfDaysBetween());
    }

    public static int getNumberOfDaysBetween() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first date:");
        String firstDateNew = scan.next();
        LocalDate firstDate = LocalDate.parse(firstDateNew);
        System.out.println("Enter second date:");
        String secondDateNew = scan.next();
        LocalDate secondDate = LocalDate.parse(secondDateNew);
        return((int) ChronoUnit.DAYS.between(firstDate, secondDate));

    }
}