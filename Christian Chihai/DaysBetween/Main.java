import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static int getNumberOfDaysBetween(LocalDateTime fromDate, LocalDateTime toDate) {
        if (fromDate.isBefore(toDate)) {
            int daysBetween = 0;
            int startYear = fromDate.getYear();

            YEAR: while (startYear <= toDate.getYear()) {
                for(int month = 1; month <= 12; month++) {
                    if (startYear == fromDate.getYear() && month < fromDate.getMonthValue())
                        continue;
                    else if (startYear == fromDate.getYear() && month == fromDate.getMonthValue())
                        daysBetween += Month.of(month).maxLength() - fromDate.getDayOfMonth();
                    else if (startYear == toDate.getYear() && month == toDate.getMonthValue()) {
                        daysBetween += toDate.getDayOfMonth();
                        break YEAR;
                    }
                    else
                        daysBetween += Month.of(month).maxLength();
                }
                startYear++;
            }
            return daysBetween;
        }
        return -1;
    }

    public static void main(String[] args) {
        LocalDateTime firstDate = LocalDateTime.of(2022, 8, 17, 8, 14, 10);
        LocalDateTime secondDate = LocalDateTime.of(2024, 10, 8, 9, 45, 5);

        System.out.println(getNumberOfDaysBetween(firstDate, secondDate));
    }
}