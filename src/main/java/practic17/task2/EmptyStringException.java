package practic17.task2;

public class EmptyStringException extends RuntimeException {

    public EmptyStringException() {
        this("String is empty");
    }

    public EmptyStringException(String message) {
        super(message);
    }
}
