package Tables;

public class EmployeeInfo {
    private static int count = 0;
    private int id, age;
    private String name, contactNr;

    public EmployeeInfo(){
    }

    public EmployeeInfo(String name, int age, String contactNr) {
        id = ++count;
        this.name = name;
        this.age = age;
        this.contactNr = contactNr;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getContactNr() {
        return contactNr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setContactNr(String contactNr) {
        this.contactNr = contactNr;
    }
}