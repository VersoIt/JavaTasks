package practic23;

public class Drink implements Item {

    private final int cost;

    private final String name;

    private final String description;

    public Drink(String name, String description) {
        this(name, description, 0);
    }

    public Drink(String name, String description, int cost) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || getClass() != other.getClass())
            return false;

        return name.equals(((Drink) other).name);
    }

    @Override
    public int compareTo(Item other) {
        return cost - other.getCost();
    }
}
