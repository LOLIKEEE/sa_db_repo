package Tables;

public class ProjectOwner {
    private int projectOwnerId;
    private String projectOwnerName;

    public ProjectOwner(int projectOwnerId, String projectOwnerName) {
        this.projectOwnerId = projectOwnerId;
        this.projectOwnerName = projectOwnerName;
    }

    void setProjectOwnerId(int projectOwnerId) {
        this.projectOwnerId = projectOwnerId;
    }

    void setProjectOwnerName(String projectOwnerName) {
        this.projectOwnerName = projectOwnerName;
    }

    public int getProjectOwnerId() {
        return projectOwnerId;
    }

    public String getProjectOwnerName() {
        return projectOwnerName;
    }
}