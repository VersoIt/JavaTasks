package practic8.task1;

import java.awt.*;

public class Circle extends Shape {

    private final int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillOval(getX() - radius, getY() - radius, 2 * radius, 2 * radius);
    }
}
