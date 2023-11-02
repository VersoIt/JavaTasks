package practic8.task3;

import javax.swing.*;

public class AnimationWindow extends JFrame {

    private int currentFrameIndex = 0;

    private final JLabel imageLabel;

    public static void main(String[] args) {
        new AnimationWindow(new String[]{"C:\\Users\\user\\Documents\\0_7c779_5df17311_orig.jpg", "C:\\Users\\user\\Documents\\images.jpg"});
    }

    public AnimationWindow(String[] imageUris) {
        imageLabel = new JLabel();
        add(imageLabel);
        setSize(1920, 1080);
        setVisible(true);

        startAnimation(imageUris);
    }

    private void startAnimation(String[] imageUris) {
        Timer timer = new Timer(1000, e -> {
            displayNextFrame(imageUris);
        });
        timer.start();
    }

    private void displayNextFrame(String[] imageUris) {
        if (currentFrameIndex < imageUris.length) {
            imageLabel.setIcon(new ImageIcon(imageUris[currentFrameIndex]));
        }
        ++currentFrameIndex;
    }
}