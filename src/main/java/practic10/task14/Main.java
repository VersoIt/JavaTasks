package practic10.task14;

public class Main {

    public static void main(String[] args) {
        solve(123);
    }

    public static void solve(int number) {
        if (number < 10) {
            System.out.printf("%d ", number);
            return;
        }

        solve(number / 10);
        System.out.printf("%d ", number % 10);
    }
}
