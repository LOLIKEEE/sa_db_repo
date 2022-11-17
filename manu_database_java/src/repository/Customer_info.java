package repository;

public class Customer_info {

    private int customer_id;
    private String customer_name ;
    private String customer_phone_number;


    public Customer_info(int customer_id, String customer_name, String customer_phone_number) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_phone_number = customer_phone_number;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone_number() {
        return customer_phone_number;
    }

    public void setCustomer_phone_number(String customer_phone_number) {
        this.customer_phone_number = customer_phone_number;
    }
}
