package dto;

public class ProjectName {
    private Integer id;
    private String projectName;

    public ProjectName(){

    }

    public ProjectName(final Integer id,final String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "ProjectName{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
