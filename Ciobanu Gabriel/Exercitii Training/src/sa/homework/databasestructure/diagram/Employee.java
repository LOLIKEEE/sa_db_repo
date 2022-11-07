package sa.homework.databasestructure.diagram;

public class Employee {
    private static int count = 0;
    private final int id;
    private String name;
    private int age;
    private String phoneNumber;

    public Employee(String name, int age, String phoneNumber) {
        id = count++;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return " Employee: " + name + " Age: " + age + " Phone Number: " + phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }
}
