package practic17.task2;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
