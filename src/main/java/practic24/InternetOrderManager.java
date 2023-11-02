package practic24;

import java.util.HashMap;
import java.util.Map;

public class InternetOrderManager implements OrdersManager<String> {

    private final Map<String, Order> orders;

    public InternetOrderManager() {
        orders = new HashMap<>();
    }

    @Override
    public Order getOrder(String address) {
        return orders.get(address);
    }

    @Override
    public void remove(String address) {
        orders.remove(address);
    }

    @Override
    public void addItemToOrderBy(String address, Item item) {
        orders.get(address).add(item);
    }

    @Override
    public int itemsQuantity(String name) {
        int amount = 0;

        for (Order order : orders.values()) {
            amount += order.itemQuantity(name);
        }

        return amount;
    }

    @Override
    public Order[] getOrders() {
        return orders.values().toArray(new Order[0]);
    }

    @Override
    public int ordersCostSummary() {
        int sum = 0;
        for (Order order : orders.values()) {
            sum += order.costTotal();
        }
        return sum;
    }

    @Override
    public int ordersQuantity() {
        return orders.size();
    }
}
