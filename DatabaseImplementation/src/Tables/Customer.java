package Tables;
public class Customer {
	protected short customerId;
	protected String customerName;
	protected String customerContactNumber;
	
	public Customer(short customerId, String customerName, String customerContactNumber) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerContactNumber = customerContactNumber;
	}
	
	void setCustomerId(short customerId) {
		this.customerId = customerId;
	}
	
	void setCustomerName(String customer_name) {
		this.customerName = customer_name;
	}
	
	void setCustomerContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}
	
	public short getCustomerId() {
		return customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getCustomerContactNumber() {
		return customerContactNumber;
	}
}
