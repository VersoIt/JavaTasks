package practic17.task2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Activity extends JFrame {

    private final Stack<Fragment> backStack = new Stack<>();

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Activity activity = new Activity();
        Fragment findStudentFragment = new FindStudentFragment(activity, students);
        Fragment showStudentsFragment = new StudentsFragment(activity, students);
        Fragment addStudentFragment = new AddStudentFragment(activity, students);
        Fragment selectionFragment = new SelectionFragment(activity, showStudentsFragment, addStudentFragment, findStudentFragment);

        activity.addFragment(selectionFragment);
    }

    public Activity() {
        initSettings();
    }

    void addFragment(Fragment fragment) {
        if (!backStack.isEmpty() && backStack.peek() != null)
            backStack.peek().remove();

        backStack.add(fragment);
        fragment.display();
    }

    private void initSettings() {
        setSize(400, 320);
        setVisible(true);
    }

    public void popBackStack() {
        Fragment previous = backStack.pop();
        backStack.peek().display();
        previous.remove();
    }
}