package sa.homework.databasestructure.diagram;

public class Comment {
    private static int count = 0;
    private final int id;
    private String description;

    public Comment(String description) {
        id = count++;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return " Comment: " + description;
    }
}
