package practic24;

import practic23.InternetOrder;

import java.util.HashMap;
import java.util.Map;

public class TableOrderManager implements OrdersManager<Integer> {

    private final Map<Integer, Order> orders;

    private final int[] tableNumbers;

    public TableOrderManager(int[] tableNumbers) {
        orders = new HashMap<>();

        this.tableNumbers = tableNumbers;
    }

    private boolean isTableFree(int tableNumber) {
        for (Integer currentTable : orders.keySet()) {
            if (currentTable == tableNumber)
                return false;
        }

        return true;
    }

    private boolean isTableNumberNotExists(int tableNumber) {
        for (int table : tableNumbers) {
            if (table == tableNumber)
                return false;
        }

        return true;
    }

    @Override
    public Order getOrder(Integer tableNumber) {
        if (isTableNumberNotExists(tableNumber))
            throw new IllegalArgumentException();

        return orders.get(tableNumber);
    }

    @Override
    public void remove(Integer tableNumber) {
        if (isTableNumberNotExists(tableNumber))
            throw new IllegalArgumentException();

        orders.remove(tableNumber);
    }

    @Override
    public void addItemToOrderBy(Integer tableNumber, Item item) {
        if (isTableNumberNotExists(tableNumber))
            throw new IllegalArgumentException();

        if (!orders.containsKey(tableNumber)) {
            RestaurantOrder order = new RestaurantOrder();
            order.add(item);
            orders.put(tableNumber, order);
            return;
        }

        orders.get(tableNumber).add(item);
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