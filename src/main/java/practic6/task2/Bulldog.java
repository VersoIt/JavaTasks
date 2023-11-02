package practic6.task2;

public class Bulldog extends Dog {
    public Bulldog(String name, int age) {
        super(name, age);
    }

    @Override
    public void describe() {
        System.out.println("Это Бульдог по имени " + getName() + ", возраст " + getAge() + " лет.");
    }
}