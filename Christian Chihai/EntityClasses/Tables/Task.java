package Tables;

public class Task {
    private int taskId;
    protected String taskName;

    public Task(short taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    void setTaskId(short taskId) {
        this.taskId = taskId;
    }

    void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }
}