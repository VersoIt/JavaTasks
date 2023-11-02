package practic17.task2;

import javax.swing.*;
import java.util.List;

public class FindStudentFragment extends JPanel implements Fragment {

    private final Activity activity;

    private final List<Student> students;

    public FindStudentFragment(Activity activity, List<Student> students) {
        this.activity = activity;
        this.students = students;

        initUi();
    }

    private void initUi() {
        JTextField nameField = new JTextField("Имя студента");
        JButton findButton = new JButton("Найти");

        findButton.addActionListener(e -> {
            try {
                Student student = findStudentByName(nameField.getText());
                JOptionPane.showMessageDialog(null, String.format("%s: %d", student.getName(), student.getScore()));
            } catch (StudentNotFoundException exception) {
                JOptionPane.showMessageDialog(null, "Студент не найден!");
            }
        });

        add(nameField);
        add(findButton);

        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> activity.popBackStack());
        add(backButton);
    }

    private Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }

        throw new StudentNotFoundException();
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
