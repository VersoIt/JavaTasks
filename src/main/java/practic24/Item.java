package practic24;

public interface Item extends Comparable<Item> {

    int getCost();

    String getDescription();

    String getName();
}
