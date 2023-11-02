package practic16.task6;

public class Exception {

    public static void main(String[] args) {
        practic16.task6.Exception exception = new practic16.task6.Exception();
        try {
            exception.getDetails(null);
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        // do something with the key
    }
}
