package practic24;

public class Main {

    public static void main(String[] args) {
        OrdersManager<Integer> orderManager = new TableOrderManager(new int[]{1, 2, 3, 5, 10});

        orderManager.addItemToOrderBy(1, new Dish("first", "some description", 1));
        orderManager.addItemToOrderBy(2, new Dish("second", "some description", 3));
        orderManager.addItemToOrderBy(2, new Dish("third", "some description", 30));
        orderManager.addItemToOrderBy(3, new Dish("fourth", "some description", 2));
        orderManager.addItemToOrderBy(5, new Drink("fifth", "some description", DrinkType.MILk));

        System.out.println();
        System.out.println("Изначальное состояние: ");
        for (Order currentOrder : orderManager.getOrders()) {
            for (Item item : currentOrder) {
                System.out.println(item);
            }
        }

        System.out.println();
        System.out.println("После удаления элементов с именем 'first': ");
        orderManager.remove(1);
        for (Order currentOrder : orderManager.getOrders()) {
            for (Item item : currentOrder) {
                System.out.println(item);
            }
        }
    }
}
