package dto;

import java.util.Date;

public class TimeTracking {
    private Integer id;
    private Employees employeeId;
    private Customer customer;
    private ProjectName projectName;
    private ProjectOwner projectOwner;
    private TaskType taskType;
    private Integer workedHours;
    private Date startDate;
    private Date endDate;
    private String comment;
    private String recordStatus;

    public TimeTracking(){

    }

    public TimeTracking(final Integer id,final Employees employeeId,final Customer customer,final ProjectName projectName,final ProjectOwner projectOwner,
                        final TaskType taskType,final Integer workedHours,final Date startDate,final Date endDate,final String comment,final String recordStatus) {
        this.id = id;
        this.employeeId = employeeId;
        this.customer = customer;
        this.projectName = projectName;
        this.projectOwner = projectOwner;
        this.taskType = taskType;
        this.workedHours = workedHours;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
        this.recordStatus = recordStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employees getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employees employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public void setProjectName(ProjectName projectName) {
        this.projectName = projectName;
    }

    public ProjectOwner getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(ProjectOwner projectOwner) {
        this.projectOwner = projectOwner;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "TimeTracking{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", customer=" + customer +
                ", projectName=" + projectName +
                ", projectOwner=" + projectOwner +
                ", taskType=" + taskType +
                ", workedHours=" + workedHours +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", comment='" + comment + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                '}';
    }
}
