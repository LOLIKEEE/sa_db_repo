package Tables;
public class Employee {
	protected short employeeId;
	protected String employeeName;
	protected short employeeAge;
	protected String employeeContactNumber;
	
	public Employee(short employeeId, String employeeName, short employeeAge, String employeeContactNumber) {
		this.employeeId = employeeId;
		this.employeeAge = employeeAge;
		this.employeeName = employeeName;
		this.employeeContactNumber = employeeContactNumber; 
	}
	
	void setEmployeeId(short employeeId) {
		this.employeeId = employeeId;
	}
	
	void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	void setEmployeeAge(short employee_age) {
		this.employeeAge = employee_age;
	}
	
	void setEmployeeContactNumber(String employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
	}
	
	public short getEmployeeId() {
		return employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public short getEmployeAge() {
		return employeeAge;
	}
	
	public String getEmployeeContactNumber() {
		return employeeContactNumber;
	}
}
