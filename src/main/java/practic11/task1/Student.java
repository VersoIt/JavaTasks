package practic11.task1;

public class Student implements Comparable<Student> {

    private int id;

    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{ name: %s, id: %d }", name, id);
    }

    @Override
    public int compareTo(Student other) {
        return id - other.id;
    }
}
