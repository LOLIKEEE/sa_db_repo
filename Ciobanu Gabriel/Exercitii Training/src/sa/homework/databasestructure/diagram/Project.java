package sa.homework.databasestructure.diagram;

public class Project {
    private static int count = 0;
    private final int id;
    private String name;

    public Project(String name) {
        id = count++;
        this.name = name;
    }

    @Override
    public String toString() {
        return " Project:" + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
