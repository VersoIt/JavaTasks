package practic6.task3;

public class Chair extends Furniture {

    public Chair(String material, double price) {
        super(material, price);
    }

    @Override
    public void describe() {
        System.out.println("Стул стоимостью " + getPrice() + " и материалом " + getMaterial());
    }
}
