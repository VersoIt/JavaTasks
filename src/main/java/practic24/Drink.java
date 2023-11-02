package practic24;

public class Drink implements Item {

    private final int cost;

    private final String name;

    private final String description;

    private double alcoholVolume;

    private final DrinkType type;

    public Drink(String name, String description, DrinkType type) {
        this(name, description, 0, type);
    }

    public Drink(String name, String description, int cost, DrinkType type) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.type = type;
        this.alcoholVolume = 0.0;
    }

    public DrinkType getType() {
        return type;
    }

    public double getAlcoholVolume() {
        return alcoholVolume;
    }

    public void setAlcoholVolume(double volume) {
        alcoholVolume = volume;
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

    @Override
    public String toString() {
        return "Drink{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", alcoholVolume=" + alcoholVolume +
                ", type=" + type +
                '}';
    }
}
