package practic22.task2;

public class VictorianFurnitureFactory implements AbstractFurnitureFactory {

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }

    @Override
    public Closet createCloset() {
        return new VictorianCloset();
    }
}
