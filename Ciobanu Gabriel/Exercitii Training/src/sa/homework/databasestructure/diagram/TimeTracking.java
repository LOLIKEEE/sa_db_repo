package sa.homework.databasestructure.diagram;

import java.time.LocalDate;
import java.util.*;

public class TimeTracking {
    private final String id = UUID.randomUUID().toString();
    private Comment comment;
    private Customer customer;
    private Employee employee;
    private Project project;
    private ProjectOwner projectOwner;
    private RecordStatus recordStatus;
    private Task task;
    private int workedHours;
    private LocalDate startDate;
    private LocalDate endDate;

    public TimeTracking(Comment comment, Customer customer, Employee employee, Project project,
                        ProjectOwner projectOwner, RecordStatus recordStatus,
                        Task task, int workedHours, LocalDate startDate, LocalDate endDate) {
        this.comment = comment;
        this.customer = customer;
        this.employee = employee;
        this.project = project;
        this.projectOwner = projectOwner;
        this.recordStatus = recordStatus;
        this.task = task;
        this.workedHours = workedHours;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Id: " + id + " " + employee.toString() + " " + project.toString() + " Worked Hours: " + workedHours +
                " " + projectOwner.toString() + " " + task.toString() + " Start Date: " + startDate +
                " End Date: " + endDate + " " + customer.toString() + " " + recordStatus.toString() +
                " " + comment.toString();
    }

}
