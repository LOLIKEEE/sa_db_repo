package repository;

public class Project_info {

    private int project_id;
    private Customer_info customer_id;
    private String project_owner;
    private String project_name;


    public Project_info(int project_id, Customer_info customer_id, String project_owner, String project_name) {
        this.project_id = project_id;
        this.customer_id = customer_id;
        this.project_owner = project_owner;
        this.project_name = project_name;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public Customer_info getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer_info customer_id) {
        this.customer_id = customer_id;
    }

    public String getProject_owner() {
        return project_owner;
    }

    public void setProject_owner(String project_owner) {
        this.project_owner = project_owner;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
