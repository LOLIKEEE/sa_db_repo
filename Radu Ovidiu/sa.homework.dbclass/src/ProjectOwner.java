
public class ProjectOwner {
   private int ownerId;
   private String projectOwnerName;
    public ProjectOwner(int ownerId, String projectOwnerName){
        this.ownerId = ownerId;
        this.projectOwnerName = projectOwnerName;
    }

    void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    void setProjectOwnerName(String projectOwnerName) {
        this.projectOwnerName = projectOwnerName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getProjectOwnerName() {
        return projectOwnerName;
    }
}
