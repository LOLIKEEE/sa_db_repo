package sa.homework.databasestructure;

import sa.homework.databasestructure.diagram.*;

import java.time.LocalDate;
import java.time.Month;

public class TimeSheet {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ciobanu Gabriel",28, "0040 752500884" );
        Customer customer1 = new Customer("Porsche" ,"0044754220000");
        Project project1 = new Project("Porsche Backend");
        ProjectOwner projectOwner1 = new ProjectOwner("Darius");
        RecordStatus recordStatus1 = new RecordStatus("unpaid");
        Task task1 = new Task("Development");
        Comment comment1 = new Comment("Refactoring: PBP-0001");

        TimeTracking timeTracking1 = new TimeTracking(comment1,customer1,employee1,project1,projectOwner1,recordStatus1,
                task1,18, LocalDate.of(2022, Month.AUGUST,18),LocalDate.of(2022,Month.NOVEMBER,24));

        System.out.println(timeTracking1);
    }
}
