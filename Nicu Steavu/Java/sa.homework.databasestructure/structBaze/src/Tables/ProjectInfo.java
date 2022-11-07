package Tables;

public class ProjectInfo {
    private static int count = 0;
    private CustomerInfo customer;
    private int id;
    private String project, owner;

    public ProjectInfo(){
    }

    public ProjectInfo(String project, String owner, CustomerInfo customer) {
        id = ++count;
        this.project = project;
        this.owner = owner;
        this.customer = customer;
    }

    public ProjectInfo(String project, String owner, String customerName, String customerContactNr) {
        id = ++count;
        this.project = project;
        this.owner = owner;
        this.customer = new CustomerInfo(customerName, customerContactNr);
    }

    public int getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public String getOwner() {
        return owner;
    }

    public CustomerInfo getCustomer(){
        return customer;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCustomer(CustomerInfo customer) {
        this.customer = customer;
    }
}