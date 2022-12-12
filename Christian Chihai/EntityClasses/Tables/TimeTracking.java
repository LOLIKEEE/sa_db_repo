package Tables;
import java.time.LocalDate;

public class TimeTracking {
    private int timeTrackingId;
    private Employee employee;
    private Project project;
    private int workedHours;
    private ProjectOwner pOwner;
    private Task task;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Customer customer;
    private String comments;
    private RecordStatus record;

    TimeTracking(int timeTrackingId, Employee employee, Project project, short workedHours, ProjectOwner pOwner,Task task, LocalDate dateStart, LocalDate dateEnd, Customer customer, String comments, RecordStatus record) {
        this.timeTrackingId = timeTrackingId;
        this.employee = employee;
        this.project = project;
        this.workedHours = workedHours;
        this.pOwner = pOwner;
        this.task = task;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customer = customer;
        this.comments = comments;
        this.record = record;
    }


    public int getTimeTrackingId() {
        return timeTrackingId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public int getWorkingHours() {
        return workedHours;
    }

    public ProjectOwner getProjectOwner() {
        return pOwner;
    }

    public Task getTask() {
        return task;
    }

    public LocalDate getStartDate() {
        return dateStart;
    }

    public LocalDate getEndDate() {
        return dateEnd;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getComments() {
        return comments;
    }

    public RecordStatus getRecordStatus() {
        return record;
    }

}