package practic9.task2;

public class Main {

    public static void main(String[] args) {
        Priceable car = new Car();
        Priceable furniture = new Furniture();

        System.out.println(car.getPrice() + "$");
        System.out.println(furniture.getPrice() + "$");
    }
}
