package Tables;
public class Tasks {
	protected short taskId;
	protected String taskName;
	
	public Tasks(short taskId, String taskName) {
		this.taskId = taskId;
		this.taskName = taskName;
	}
	
	void setTaskId(short taskId) {
		this.taskId = taskId;
	}
	
	void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public short getTaskId() {
		return taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}
}
