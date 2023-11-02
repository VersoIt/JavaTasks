package practic6.task2;

public class Labrador extends Dog {
    public Labrador(String name, int age) {
        super(name, age);
    }

    @Override
    public void describe() {
        System.out.println("Это Лабрадор по имени " + getName() + ", возраст " + getAge() + " лет.");
    }
}