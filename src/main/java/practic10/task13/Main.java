package practic10.task13;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        solveHelper(new Scanner(System.in), 1);
    }

    private static void solveHelper(Scanner scanner, int currentPosition) {
        int current = scanner.nextInt();
        if (current == 0) {
            return;
        }

        if (currentPosition % 2 != 0) {
            System.out.println(current);
        }

        solveHelper(scanner, currentPosition + 1);
    }
}