package sa.demo.abstraction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = getPersonList();

        for (Person person: personList) {
            if (person instanceof Worker) {
                Worker worker = (Worker) person;
                System.out.println(worker.getJobTitle());
            }
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println(student.getYear());
            }

        }
    }

    public static List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Worker());
        personList.add(new Student());
        personList.add(new Student());
        personList.add(new Student());
        personList.add(new Student());

        return personList;
    }
}