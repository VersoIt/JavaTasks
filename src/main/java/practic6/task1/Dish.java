package practic6.task1;

public abstract class Dish {
    private String material;
    private double diameter;

    public Dish(String material, double diameter) {
        this.material = material;
        this.diameter = diameter;
    }

    public abstract void describe();

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}
