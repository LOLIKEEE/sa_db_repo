package tables;

public class Project {
    private int projectId;
    private String projectName;

    public Project(int projectId, String projectName) {
        this.projectName = projectName;
        this.projectId = projectId;
    }

    void setProjectId(short projectId) {
        this.projectId = projectId;
    }

    void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }
}
