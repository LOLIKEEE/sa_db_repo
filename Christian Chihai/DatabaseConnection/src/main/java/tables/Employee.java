package tables;

import java.util.Scanner;

public class Employee {
    protected int employeeId;
    protected String employeeName;
    protected int employeeAge;
    protected String employeeContactNumber;
    private static final Scanner cin = new Scanner(System.in);

    public Employee() {}
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

    public int getEmployeAge() {
        return employeeAge;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public Employee createEmployee() {
        Employee newEmployee = new Employee();
        System.out.print("NAME: "); newEmployee.setEmployeeName(cin.next());
        System.out.print("AGE: "); newEmployee.setEmployeeAge(cin.nextInt());
        System.out.print("PHONE: "); newEmployee.setEmployeeContactNumber(cin.next());

        return newEmployee;
    }
}
