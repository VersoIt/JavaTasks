package practic22.task3;

import javax.swing.*;

public interface Showman {

    void setPanel(JPanel panel);

    void show(Document document);

    String content();

    void clear();
}
