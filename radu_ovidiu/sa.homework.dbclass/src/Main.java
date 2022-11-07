
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Employees employees = new Employees(1, "Nicolae", 26,"0040754827541");
        Customer customer = new Customer(1,"GSD Software & Technology", "0040722222222");
        ProjectName projectName = new ProjectName(1,"Software Academy Training");
        ProjectOwner projectOwner = new ProjectOwner(1, "Darius");
        TaskType taskType = new TaskType(1, "Developement");
        LocalDate startDate = LocalDate.of(2022,9,26);
        LocalDate endDate = LocalDate.of(2022,9,26);
        TimeTracking timeTracking = new TimeTracking(1,employees,customer, projectName,projectOwner, taskType,2,startDate,endDate, "I studied the mysql tutorial pretty hard.","paid");

        System.out.println("ID: "+timeTracking.getId()+"\nEmployeeName: "+timeTracking.getEmployeeId().getEmployeeName()+"\nCustomer: "+timeTracking.getCustomerId().getCustomerName()+"\nProject:"+timeTracking.getProjectId().getProjectName()+
                        "\nProject owner: "+timeTracking.getOwnerId().getProjectOwnerName()+"\nTask type: "+timeTracking.getTaskId().getType()+"\nWorked hours: "+timeTracking.getWorkedHours()+
                        "\nStart date: "+timeTracking.getStartDate()+"\nEnd date: "+timeTracking.getEndDate()+
                "\nComment: "+timeTracking.getComment()+"\nRecord status: " +timeTracking.getRecordStatus());
    }
}