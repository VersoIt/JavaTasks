package practic17.task2;

import javax.swing.*;
import java.util.List;

public class SelectionFragment extends JPanel implements Fragment {

    private final JButton addStudentButton;

    private final JButton showStudentsButton;

    private final Activity activity;

    private final Fragment addStudentFragment;
    private final Fragment studentsListFragment;

    private final JButton findStudentButton;

    private final Fragment findStudentFragment;

    public SelectionFragment(Activity activity, Fragment studentsListFragment, Fragment addStudentFragment, Fragment findStudentFragment) {
        this.activity = activity;

        addStudentButton = new JButton("Добавить студента");
        showStudentsButton = new JButton("Показать список студентов");
        findStudentButton = new JButton("Найти студента");

        add(addStudentButton);
        add(showStudentsButton);
        add(findStudentButton);

        this.addStudentFragment = addStudentFragment;
        this.studentsListFragment = studentsListFragment;
        this.findStudentFragment = findStudentFragment;

        initActionsForUi();
    }

    private void initActionsForUi() {
        addStudentButton.addActionListener(e -> activity.addFragment(addStudentFragment));
        showStudentsButton.addActionListener(e -> activity.addFragment(studentsListFragment));
        findStudentButton.addActionListener(e -> activity.addFragment(findStudentFragment));
    }

    @Override
    public void display() {
        activity.add(this);
        System.out.println("selection added");
        revalidate();
        repaint();
    }

    @Override
    public void remove() {
        activity.remove(this);
        System.out.println("selection removed");
        revalidate();
        repaint();
    }
}
