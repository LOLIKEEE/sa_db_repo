
public class TaskType {
    private int taskId;
    private String type;
    public TaskType(int taskId, String type){
        this.taskId = taskId;
        this.type = type;
    }

    void setId(int taskId) {
        this.taskId = taskId;
    }

    void setType(String type) {
        this.type = type;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getType() {
        return type;
    }
}
