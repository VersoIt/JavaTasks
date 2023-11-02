package practic17.task2;

import javax.swing.*;
import java.util.List;

public class StudentsFragment extends JPanel implements Fragment {

    private final Activity activity;

    private final List<Student> students;

    private JPanel studentsPanel = null;

    public StudentsFragment(Activity activity, List<Student> students) {
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> activity.popBackStack());

        JButton sortStudentsButton = new JButton("Сортировать");
        sortStudentsButton.addActionListener(e -> {
            sortStudents();
            students.forEach(System.out::println);
            showStudents(students);
        });

        add(backButton);
        add(sortStudentsButton);
        add(new JLabel("Студенты: "));

        showStudents(students);

        this.students = students;
        this.activity = activity;
    }

    private void showStudents(List<Student> students) {
        if (studentsPanel != null) {
            remove(studentsPanel);
            studentsPanel.setVisible(false);
        }

        studentsPanel = new JPanel();
        studentsPanel.setLayout(new BoxLayout(studentsPanel, BoxLayout.Y_AXIS));

        for (Student student : students) {
            studentsPanel.add(new JLabel(String.format("%s: %d", student.getName(), student.getScore())));
        }

        add(studentsPanel);
        revalidate();
        repaint();
    }

    private void sortStudents() {
        StudentsDriver driver = new StudentsDriver();
        driver.mergeSort(students);
        showStudents(students);
    }

    @Override
    public void display() {
        activity.add(this);
        revalidate();
        showStudents(students);
        repaint();
    }

    @Override
    public void remove() {
        activity.remove(this);
        revalidate();
        repaint();
    }
}
