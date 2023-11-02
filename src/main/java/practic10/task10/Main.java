package practic10.task10;

public class Main {
    public static void main(String[] args) {
        int number = 123;
        System.out.println(reverse(number, 0));
    }

    private static int reverse(int number, int reversed) {
        if (number == 0)
            return reversed;

        reversed = reversed * 10 + number % 10;
        return reverse(number / 10, reversed);
    }
}
