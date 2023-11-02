package practic15.task1.view;

import practic15.task1.controller.StudentController;
import practic15.task1.model.Student;
import practic15.task1.repository.StudentRepository;

import javax.swing.*;

public class StudentScreen extends JFrame {

    public static void main(String[] args) {
        StudentController controller = new StudentController(new StudentRepository(), new StudentScreen());
        controller.fetchStudent();
    }

    public void printStudentDetails(Student student) {
        System.out.println(student);
    }
}
