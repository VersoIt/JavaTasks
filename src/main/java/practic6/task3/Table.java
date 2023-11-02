package practic6.task3;

public class Table extends Furniture {

    public Table(String material, double price) {
        super(material, price);
    }

    @Override
    public void describe() {
        System.out.println("Стол стоимостью " + getPrice() + " и материалом " + getMaterial());
    }
}
