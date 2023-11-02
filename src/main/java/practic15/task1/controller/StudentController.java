package practic15.task1.controller;

import practic15.task1.repository.StudentRepository;
import practic15.task1.view.StudentScreen;

public class StudentController {

    private final StudentRepository studentRepository;

    private final StudentScreen studentScreen;

    public StudentController(StudentRepository studentRepository, StudentScreen studentScreen) {
        this.studentRepository = studentRepository;
        this.studentScreen = studentScreen;
    }

    public void fetchStudent() {
        studentScreen.printStudentDetails(studentRepository.fetchStudent());
    }
}
