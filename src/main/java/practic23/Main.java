package practic23;

public class Main {

    public static void main(String[] args) {
        Order order = new InternetOrder();

        order.add(new Dish("first", "1", 1));
        order.add(new Dish("second", "2", 2));
        order.add(new Dish("third", "3", 3));
        order.add(new Dish("fourth", "4", 4));

        System.out.println();
        System.out.println("Изначальное состояние: ");
        for (Item item : order) {
            System.out.println(item);
        }

        order.sortDescending();

        System.out.println();
        System.out.println("После сортировки по убыванию: ");

        for (Item item : order) {
            System.out.println(item);
        }

        System.out.println();
        System.out.println("После удаления элементов с именем 'first': ");
        order.removeAll("first");
        for (Item item : order) {
            System.out.println(item);
        }
    }
}
