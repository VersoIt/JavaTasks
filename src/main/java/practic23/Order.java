package practic23;

public interface Order extends Iterable<Item> {

    boolean add(Item item);

    boolean remove(Item item);

    boolean removeAll(String name);

    int itemQuantity(String name);

    void sortDescending();

    int itemQuantity();

    int costTotal();

    Object[] getItems();

    void sort();

    String[] itemNames();
}
