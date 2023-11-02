package practic17.task2;

import javax.swing.*;
import java.util.List;

public class AddStudentFragment extends JPanel implements Fragment {

    private final Activity activity;

    public AddStudentFragment(Activity activity, List<Student> students) {
        this.activity = activity;

        JTextField scoreField = new JTextField("1   ");
        JTextField nameField = new JTextField("John    ");

        add(nameField);
        add(scoreField);

        JButton addButton = new JButton("Добавить студента");
        addButton.addActionListener(e -> {
            try {
                students.add(new Student(Integer.parseInt(scoreField.getText().trim()), nameField.getText().trim()));
                JOptionPane.showMessageDialog(null, "Студент успешно добавлен!");
            }
            catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Ошибка при вводе среднего балла!");
            }
        });
        add(addButton);

        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> activity.popBackStack());
        add(backButton);
    }

    @Override
    public void display() {
        activity.add(this);
        revalidate();
        repaint();
    }

    @Override
    public void remove() {
        activity.remove(this);
        revalidate();
        repaint();
    }
}
