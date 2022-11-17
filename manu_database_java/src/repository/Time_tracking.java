package repository;

import java.util.Date;

public class Time_tracking {

    private int employee_id;
    private int project_id;
    private int task_id ;
    private int worked_hours;
    private Date start_date;
    private Date end_date ;
    private String comment ;
    private int status_id;

    //nu am inclus linkurile pt getter and setter

private  Employee_info employee_info_employee_id; //joins
private Task_type task_type_task_id;
private Result_status result_status_status_id;
private Project_info project_info_project_id;


    public Time_tracking(int employee_id, int project_id, int task_id, int worked_hours, Date start_date, Date end_date, String comment, int status_id, Employee_info employee_info_employee_id, Task_type task_type_task_id, Result_status result_status_status_id, Project_info project_info_project_id) {
        this.employee_id = employee_id;
        this.project_id = project_id;
        this.task_id = task_id;
        this.worked_hours = worked_hours;
        this.start_date = start_date;
        this.end_date = end_date;
        this.comment = comment;
        this.status_id = status_id;
        this.employee_info_employee_id = employee_info_employee_id;
        this.task_type_task_id = task_type_task_id;
        this.result_status_status_id = result_status_status_id;
        this.project_info_project_id = project_info_project_id;
    }

    public Employee_info getEmployee_info_employee_id() {
        return employee_info_employee_id;
    }

    public void setEmployee_info_employee_id(Employee_info employee_info_employee_id) {
        this.employee_info_employee_id = employee_info_employee_id;
    }

    public Task_type getTask_type_task_id() {
        return task_type_task_id;
    }

    public void setTask_type_task_id(Task_type task_type_task_id) {
        this.task_type_task_id = task_type_task_id;
    }

    public Result_status getResult_status_status_id() {
        return result_status_status_id;
    }

    public void setResult_status_status_id(Result_status result_status_status_id) {
        this.result_status_status_id = result_status_status_id;
    }

    public Project_info getProject_info_project_id() {
        return project_info_project_id;
    }

    public void setProject_info_project_id(Project_info project_info_project_id) {
        this.project_info_project_id = project_info_project_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getWorked_hours() {
        return worked_hours;
    }

    public void setWorked_hours(int worked_hours) {
        this.worked_hours = worked_hours;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
