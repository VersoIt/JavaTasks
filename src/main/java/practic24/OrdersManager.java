package practic24;

public interface OrdersManager<T> {

    Order getOrder(T address);

    void remove(T address);

    void addItemToOrderBy(T address, Item item);

    int itemsQuantity(String itemName);

    Order[] getOrders();

    int ordersCostSummary();

    int ordersQuantity();
}
