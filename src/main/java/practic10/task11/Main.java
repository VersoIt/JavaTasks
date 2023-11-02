package practic10.task11;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(numbersAmount(System.in));
    }

    public static int numbersAmount(InputStream in) {
        Scanner scanner = new Scanner(in);
        int prev = scanner.nextInt();
        return (prev == 1 ? 1 : 0) + numbersAmountHelper(scanner, prev);
    }

    private static int numbersAmountHelper(Scanner scanner, int prev) {
        int current = scanner.nextInt();
        if (prev == current && current == 0)
            return 0;

        return (current == 1 ? 1 : 0) + numbersAmountHelper(scanner, current);
    }
}
