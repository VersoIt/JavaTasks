package practic8.task1;

import java.awt.*;

public abstract class Shape implements Drawable {

    private final int x;
    private final int y;

    private final Color color;

    public Shape(Color color, int x, int y) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
