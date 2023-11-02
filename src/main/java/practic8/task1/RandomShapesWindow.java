package practic8.task1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomShapesWindow extends JPanel {

    private final Shape[] shapes;

    public RandomShapesWindow() {

        final int WIDTH = 800;
        final int HEIGHT = 600;
        final int NUM_SHAPES = 20;
        final Random random = new Random();

        shapes = new Shape[NUM_SHAPES];
        for (int i = 0; i < NUM_SHAPES; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int shapeType = random.nextInt(2);

            if (shapeType == 0) {
                int radius = random.nextInt(50) + 20;
                shapes[i] = new Circle(color, x, y, radius);
            } else {
                int width = random.nextInt(100) + 50;
                int height = random.nextInt(100) + 50;
                shapes[i] = new Rectangle(color, x, y, width, height);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        RandomShapesWindow panel = new RandomShapesWindow();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
