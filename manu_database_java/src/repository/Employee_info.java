package repository;

public class Employee_info {

    private int employee_id;
    private String employee_name;
    private String employee_age;
    private int employee_phone_number;
    private int employee_experience;


    public Employee_info(int employee_id, String employee_name, String employee_age, int employee_phone_number, int employee_experience) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_age = employee_age;
        this.employee_phone_number = employee_phone_number;
        this.employee_experience = employee_experience;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    public int getEmployee_phone_number() {
        return employee_phone_number;
    }

    public void setEmployee_phone_number(int employee_phone_number) {
        this.employee_phone_number = employee_phone_number;
    }

    public int getEmployee_experience() {
        return employee_experience;
    }

    public void setEmployee_experience(int employee_experience) {
        this.employee_experience = employee_experience;
    }
}
