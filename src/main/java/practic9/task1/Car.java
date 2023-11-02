package practic9.task1;

public class Car implements Nameable {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Название машины: " + name;
    }
}

