package practic8.task2;

import javax.swing.*;

public class ImageDisplay extends JFrame {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Укажите путь к картинке в качестве аргумента командной строки.");
            return;
        }

        new ImageDisplay(args[0]).setVisible(true);
    }

    private final JLabel imageLabel;

    public ImageDisplay(String uri) {
        setTitle("Image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        imageLabel = new JLabel();
        add(imageLabel);

        displayImage(uri);
    }

    private void displayImage(String uri) {
        imageLabel.setIcon(new ImageIcon(uri));
    }
}
