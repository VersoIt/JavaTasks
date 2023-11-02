package practic22.task3;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TextShowman implements Showman {


    private final JTextField textField;

    public TextShowman() {
        this.textField = new JTextField();
    }

    @Override
    public void setPanel(JPanel panel) {
        if (panel != null) {
            panel.add(textField, BorderLayout.CENTER);
        }
    }

    @Override
    public void show(Document document) {
        textField.setText(document.content());
    }

    @Override
    public String content() {
        return textField.getText();
    }

    @Override
    public void clear() {
        textField.setText("");
    }
}
