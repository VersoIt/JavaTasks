package practic9.task1;

public class Planet implements Nameable {

    private final String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Название планеты: " + name;
    }
}
