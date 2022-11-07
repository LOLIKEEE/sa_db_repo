import Tables.*;

import java.time.*;

public class Main {
    public static void main(String[] args){
        EmployeeInfo employee = new EmployeeInfo("Nicolae", 26, "+40723456789");
        CustomerInfo customer = new CustomerInfo("GSD Software and Technology", "+40722222222");
        ProjectInfo project = new ProjectInfo("SoftwareAcademy training", "Darius", customer);
        TaskType taskType = new TaskType("Development");
        ResultStatus status = new ResultStatus("Finished");
        LocalDate startDate = LocalDate.of(2022, 9, 5), endDate = LocalDate.of(2022, 9, 5);

        Timesheet timeTracking = new Timesheet(employee, project, status, taskType, 2, startDate, endDate, "I studied the tutorial pretty hard");

        System.out.println("ID: " + timeTracking.getId() +
                //"\nEmployeeID: " + timeTracking.getEmployee().getId() +
                "\nEmployeeName: " + timeTracking.getEmployee().getName() +
                "\nEmployeeContactNr: " + timeTracking.getEmployee().getContactNr() +
                //"\nProjectID: " + timeTracking.getProject().getId() +
                "\nProjectName: " + timeTracking.getProject().getProject() +
                "\nProjectOwner: " + timeTracking.getProject().getOwner() +
                //"\nCustomerID: " + timeTracking.getProject().getCustomer().getId() +
                "\nCustomerName: " + timeTracking.getProject().getCustomer().getName() +
                "\nCustomerContactNr: " + timeTracking.getProject().getCustomer().getContactNr() +
                "\nTaskType: " + timeTracking.getTask().getTask() +
                "\nResultStatus: " + timeTracking.getStatus().getStatus() +
                "\nWorkHours: "+timeTracking.getWorkHours() +
                "\nStartDate: "+timeTracking.getStartDate() +
                "\nEndDate: "+timeTracking.getEndDate() +
                "\nComment: "+timeTracking.getComment()
        );
    }
}
