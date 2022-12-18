package sa.homework.jdbc.dto;

import java.util.Date;

public class TimeTracking {
    private Integer id;
    private Employee employee;
    private Project project;
    private Integer workedHours;
    private ProjectOwner projectOwner;
    private Task task;
    private Date start;
    private Date end;
    private Customer customer;
    private RecordStatus recordStatus;
    private String comment;

    public TimeTracking() {
    }

    public TimeTracking(Integer id, Employee employee, Project project, Integer workedHours,
                        ProjectOwner projectOwner, Task task, Date start, Date end, Customer customer,
                        RecordStatus recordStatus, String comment) {
        this.id = id;
        this.employee = employee;
        this.project = project;
        this.workedHours = workedHours;
        this.projectOwner = projectOwner;
        this.task = task;
        this.start = start;
        this.end = end;
        this.customer = customer;
        this.recordStatus = recordStatus;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public ProjectOwner getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(ProjectOwner projectOwner) {
        this.projectOwner = projectOwner;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TimeTracking{" +
                "id=" + id +
                ", employee=" + employee.getName() +
                ", project=" + project.getName() +
                ", workedHours=" + workedHours +
                ", projectOwner=" + projectOwner.getName() +
                ", task=" + task.getName() +
                ", start=" + start +
                ", end=" + end +
                ", customer=" + customer.getName() +
                ", recordStatus=" + recordStatus.getStatus() +
                ", comment='" + comment + '\'' +
                '}';
    }
}
