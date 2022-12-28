package dto;

public class Employees {

    private Integer id;
    private String employeeName;
    private Integer age;
    private String employeePhoneNumber;

    public Employees(){

    }

    public Employees(final Integer id,final String employeeName,final Integer age,final String employeePhoneNumber) {
        this.id = id;
        this.employeeName = employeeName;
        this.age = age;
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                '}';
    }
}
