package sa.homework.daysbetween;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
    public static void main(String[] args) {
        LocalDateTime firstDate = LocalDateTime.of(2019,5,20,13,25,20);
        LocalDateTime secondDate = LocalDateTime.of(2020,5,21,16,25,30);
        int result = getNumberOfDaysBetween(firstDate,secondDate);
        System.out.println("Numarul de zile este : " +  result);
    }
    public static int getNumberOfDaysBetween(LocalDateTime firstDateTime, LocalDateTime secondDateTime){
        if(firstDateTime.isBefore(secondDateTime)) {
            return (int) DAYS.between(firstDateTime, secondDateTime);
        }else{
            return (int) DAYS.between(secondDateTime, firstDateTime);
        }
    }
}
