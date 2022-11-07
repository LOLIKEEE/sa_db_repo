package repository;

public class Task_type {

    private int task_id;
    private String task;


    public Task_type(int task_id, String task) {
        this.task_id = task_id;
        this.task = task;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
