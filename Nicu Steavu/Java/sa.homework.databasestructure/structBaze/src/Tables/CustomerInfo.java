package Tables;

public class CustomerInfo {
    private static int count = 0;
    private int id;
    private String name, contactNr;

    public CustomerInfo(){
    }

    public CustomerInfo(String name, String contactNr) {
        id = ++count;
        this.name = name;
        this.contactNr = contactNr;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNr() {
        return contactNr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNr(String contactNr) {
        this.contactNr = contactNr;
    }
}