package dto;

public class Customer {
    private Integer id;
    private String customerName;
    private String customerContactNumber;

    public Customer(){

    }
    public Customer(final Integer id, final String customerName, final String customerContactNumber){
        this.id = id;
        this.customerName = customerName;
        this.customerContactNumber = customerContactNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerContactNumber='" + customerContactNumber + '\'' +
                '}';
    }
}
