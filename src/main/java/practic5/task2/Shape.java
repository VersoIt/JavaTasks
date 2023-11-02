package practic5.task2;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        color = "default";
        filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean fill) {
        filled = fill;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract String toString();
}
