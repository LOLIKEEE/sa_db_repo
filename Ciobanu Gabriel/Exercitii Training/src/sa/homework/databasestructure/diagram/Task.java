package sa.homework.databasestructure.diagram;

public class Task {
    private static int count = 0;
    private final int id;
    private String name;

    public Task(String name) {
        id = count++;
        this.name = name;
    }

    @Override
    public String toString() {
        return " Task: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
