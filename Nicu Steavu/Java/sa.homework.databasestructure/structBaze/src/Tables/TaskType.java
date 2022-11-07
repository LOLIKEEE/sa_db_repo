package Tables;

public class TaskType {
    private static int count = 0;
    private int id;
    private String task;

    public TaskType(){
    }

    public TaskType(String task){
        id = ++count;
        this.task = task;
    }
    public int getId(){
        return id;
    }

    public String getTask(){
        return task;
    }

    public void setStatus(String task){
        this.task = task;
    }
}