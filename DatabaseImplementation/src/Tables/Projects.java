package Tables;
public class Projects {
	protected short projectId;
	protected String projectName;
	
	public Projects(short projectId, String projectName) {
		this.projectName = projectName;
		this.projectId = projectId;
	}
	
	void setProjectId(short projectId) {
		this.projectId = projectId;
	}
	
	void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public short getProjectId() {
		return projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
}
