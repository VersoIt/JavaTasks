package practic8.task1;

import java.awt.*;

public class Rectangle extends Shape {

    private final int width;

    private final int height;

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.drawRect(getX(), getY(), width, height);
    }
}
