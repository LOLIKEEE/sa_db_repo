package Tables;

public class Employee {
    private int employeeId;
    private String employeeName;
    private int employeeAge;
    private String employeeContactNumber;

    public Employee(int employeeId, String employeeName, int employeeAge, String employeeContactNumber) {
        this.employeeId = employeeId;
        this.employeeAge = employeeAge;
        this.employeeName = employeeName;
        this.employeeContactNumber = employeeContactNumber;
    }

    void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    void setEmployeeAge(int employee_age) {
        this.employeeAge = employee_age;
    }

    void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }
}
