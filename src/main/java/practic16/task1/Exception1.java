package practic16.task1;

public class Exception1 {

    public static void main(String[] args) {
        try {
            System.out.println(2 / 0);
        }
        catch (ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
