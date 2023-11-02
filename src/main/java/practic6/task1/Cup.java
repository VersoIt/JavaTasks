package practic6.task1;

public class Cup extends Dish {

    private final int capacity;

    public Cup(String material, double diameter, int capacity) {
        super(material, diameter);
        this.capacity = capacity;
    }

    public void fillCup() {
        System.out.println("Чашка заполнена вместимостью " + capacity + " мл.");
    }

    @Override
    public void describe() {
        System.out.println("Чашка из материала: " + getMaterial() + ", диаметр: " + getDiameter() + " см.");
    }
}
