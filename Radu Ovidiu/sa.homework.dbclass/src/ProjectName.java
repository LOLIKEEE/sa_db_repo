
public class ProjectName {
    private int projectId;
    private String projectName;
    public ProjectName(int projectId, String projectName){
        this.projectId = projectId;
        this.projectName = projectName;
    }

    void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }
}
