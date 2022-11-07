
public class Employees {
    private int employeeId, employeeAge;
    private String employeeName,employeePhoneNumber;
    public Employees(int employeeId,String employeeName,int employeeAge, String employeePhoneNumber){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeePhoneNumber = employeePhoneNumber;
    }
    void setEmployeeId(int employeeId){
        this.employeeId=employeeId;
    }

    void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
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

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }
}
