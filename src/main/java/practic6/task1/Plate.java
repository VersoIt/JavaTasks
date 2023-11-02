package practic6.task1;

public class Plate extends Dish {

    public Plate(String material, double diameter) {
        super(material, diameter);
    }

    @Override
    public void describe() {
        System.out.println("Тарелка из материала: " + getMaterial() + ", диаметр: " + getDiameter() + " см.");
    }
}
