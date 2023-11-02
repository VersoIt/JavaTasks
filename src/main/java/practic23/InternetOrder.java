package practic23;

import java.util.Iterator;

public class InternetOrder implements Order {

    private final LinkedList<Item> items;

    public InternetOrder() {
        this.items = new LinkedList<>();
    }

    @Override
    public boolean add(Item item) {
        return items.add(item);
    }

    @Override
    public boolean remove(Item item) {
        return items.remove(item);
    }

    @Override
    public boolean removeAll(String name) {
        return items.removeAllBy((item) -> item.getName().equals(name));
    }

    @Override
    public int itemQuantity(String name) {
        int count = 0;

        for (Item item : items) {
            if (item.getName().equals(name)) {
                ++count;
            }
        }

        return count;
    }

    @Override
    public int itemQuantity() {
        return items.size();
    }

    @Override
    public int costTotal() {
        return items.sumBy(Item::getCost);
    }

    @Override
    public Object[] getItems() {
        return items.toArray();
    }

    @Override
    public void sort() {
        items.sort();
    }

    @Override
    public void sortDescending() {
        items.sortDescending();
    }

    @Override
    public String[] itemNames() {
        String[] names = new String[items.size()];
        int index = 0;

        for (Item item : items) {
            names[index++] = item.getName();
        }

        return names;
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }
}
