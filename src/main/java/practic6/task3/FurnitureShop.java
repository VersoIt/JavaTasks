package practic6.task3;

public class FurnitureShop {

    public void displayFurniture(Furniture furniture) {
        furniture.describe();
    }

    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop();

        Chair chair = new Chair("Комфорт", 150.0);
        Table table = new Table("Обеденный", 300.0);

        shop.displayFurniture(chair);
        shop.displayFurniture(table);
    }
}
