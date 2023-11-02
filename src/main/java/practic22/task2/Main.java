package practic22.task2;

public class Main {

    public static void main(String[] args) {
        AbstractFurnitureFactory factory = new VictorianFurnitureFactory();

        Chair chair = factory.createChair();
        Closet closet = factory.createCloset();
        Table table = factory.createTable();
    }
}
