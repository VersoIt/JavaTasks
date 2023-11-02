package practic6.task1;

public class DishTest {

    public static void main(String[] args) {
        Dish cup = new Cup("first", 23, 1);
        Dish plate = new Plate("second", 10);

        cup.describe();
        plate.describe();
    }
}
