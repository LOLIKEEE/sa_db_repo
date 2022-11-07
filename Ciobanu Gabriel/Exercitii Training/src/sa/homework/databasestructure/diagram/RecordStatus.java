package sa.homework.databasestructure.diagram;

public class RecordStatus {
    private static int count = 0;
    private final int id;
    private String status;

    public RecordStatus(String status) {
        id = count++;
        this.status = status;
    }

    @Override
    public String toString() {
        return " Record Status: " + status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
