import Tables.*;
import java.util.*;
import java.time.*;

public class Timesheet {
    private static int count = 0;
    private int id, workHours;
    private LocalDate startDate, endDate;
    private String comment;
    private EmployeeInfo employee;
    private ProjectInfo project;
    private ResultStatus status;
    private TaskType task;

    public Timesheet(){
    }

    public Timesheet(EmployeeInfo employee, ProjectInfo project, ResultStatus status, TaskType task, int workHours, LocalDate startDate, LocalDate endDate, String comment){
        id = ++count;
        this.employee = employee;
        this.project = project;
        this.status = status;
        this.task = task;
        this.workHours = workHours;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public int getWorkHours(){
        return workHours;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getComment(){
        return comment;
    }

    public EmployeeInfo getEmployee(){
        return employee;
    }

    public ProjectInfo getProject(){
        return project;
    }

    public ResultStatus getStatus(){
        return status;
    }

    public TaskType getTask(){
        return task;
    }

    public void setWorkHours(int workHours){
        this.workHours = workHours;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setEmployee(EmployeeInfo employee){
        this.employee = employee;
    }

    public void setProject(ProjectInfo project){
        this.project = project;
    }

    public void setStatus(ResultStatus status){
        this.status = status;
    }

    public void setTask(TaskType task){
        this.task = task;
    }
}