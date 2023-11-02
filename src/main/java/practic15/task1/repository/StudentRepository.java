package practic15.task1.repository;

import practic15.task1.model.Student;

public class StudentRepository {

    public Student fetchStudent() {
        return new Student("#e34", "Alexey");
    }
}
