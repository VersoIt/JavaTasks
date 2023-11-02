package practic24;

public interface Order extends Iterable<Item> {

    boolean add(Item item);

    boolean remove(Item item);

    int itemQuantity(String name);

    void sortDescending();

    int itemQuantity();

    int costTotal();

    Object[] getItems();

    void sort();

    String[] itemNames();
}
