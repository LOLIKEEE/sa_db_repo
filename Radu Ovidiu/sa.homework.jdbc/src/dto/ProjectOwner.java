package dto;

public class ProjectOwner {

    private Integer id;
    private String projectOwnerName;

    public ProjectOwner(){

    }

    public ProjectOwner(final Integer id,final String projectOwnerName) {
        this.id = id;
        this.projectOwnerName = projectOwnerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectOwnerName() {
        return projectOwnerName;
    }

    public void setProjectOwnerName(String projectOwnerName) {
        this.projectOwnerName = projectOwnerName;
    }

    @Override
    public String toString() {
        return "ProjectOwnerDAO{" +
                "id=" + id +
                ", projectOwnerName='" + projectOwnerName + '\'' +
                '}';
    }
}
