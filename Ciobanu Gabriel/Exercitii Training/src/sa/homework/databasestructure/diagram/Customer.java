package sa.homework.databasestructure.diagram;

public class Customer {
    private static int count = 0;
    private final int id;
    private String name;
    private String phoneNumber;

    public Customer(String name, String phoneNumber) {
        id = count++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return " Customer: " + name + " Phone Number : " + phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
