import java.time.LocalDateTime;
import java.time.Month;

public class MainClass {
	public static int getNumberOfDaysBetween(LocalDateTime fromDate, LocalDateTime toDate) {
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
	
	public static void main(String[] args) {
		int daysBetween = 0;
		LocalDateTime firstDate = LocalDateTime.of(2022, 8, 17, 8, 14, 10);
		LocalDateTime secondDate = LocalDateTime.of(2024, 10, 8, 9, 45, 5);
		
		if(firstDate.isAfter(secondDate))
			daysBetween = getNumberOfDaysBetween(secondDate, firstDate);
		else if (firstDate.isBefore(secondDate))
			daysBetween = getNumberOfDaysBetween(firstDate, secondDate);
		else
			System.out.println("DATES ARE EQUAL, NO DAYS BETWEEN THEM ");
		
		if (daysBetween != 0)
			System.out.println(daysBetween);
	}
}







