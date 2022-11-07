
import java.time.LocalDate;
public class TimeTracking {
    private int id,workedHours;
    private Employees employeeId;
    private Customer customerId;
    private ProjectOwner ownerId;
    private TaskType taskId;
    private ProjectName projectId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String comment, recordStatus;



    public TimeTracking(int id, Employees employeeId, Customer customerId, ProjectName projectId, ProjectOwner ownerId, TaskType taskId, int workedHours, LocalDate startDate, LocalDate endDate, String comment, String recordStatus) {
        this.id=id;
        this.employeeId=employeeId;
        this.customerId = customerId;
        this.projectId = projectId;
        this.ownerId = ownerId;
        this.taskId = taskId;
        this.workedHours = workedHours;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
        this.recordStatus = recordStatus;
    }

    int getId() {
        return id;
    }

    Customer getCustomerId() {
        return customerId;
    }

    Employees getEmployeeId() {
        return employeeId;
    }

    int getWorkedHours() {
        return workedHours;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    ProjectName getProjectId() {
        return projectId;
    }

    ProjectOwner getOwnerId() {
        return ownerId;
    }

    String getComment() {
        return comment;
    }

    String getRecordStatus() {
        return recordStatus;
    }

    TaskType getTaskId() {
        return taskId;
    }

}
