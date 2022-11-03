package Tables;
public class ProjectOwners {
	protected short projectOwnerId;
	protected String projectOwnerName;
	
	public ProjectOwners(short projectOwnerId, String projectOwnerName) {
		this.projectOwnerId = projectOwnerId;
		this.projectOwnerName = projectOwnerName;
	}
	
	void setProjectOwnerId(short projectOwnerId) {
		this.projectOwnerId = projectOwnerId;
	}
	
	void setProjectOwnerName(String projectOwnerName) {
		this.projectOwnerName = projectOwnerName;
	}
	
	public short getProjectOwnerId() {
		return projectOwnerId;
	}
	
	public String getProjectOwnerName() {
		return projectOwnerName;
	}
}
