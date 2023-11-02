package practic10.task12;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(solve(System.in));
    }

    public static int solve(InputStream in) {
        return solveHelper(new Scanner(in));
    }

    public static int solveHelper(Scanner scanner) {
        int current = scanner.nextInt();
        if (current == 0)
            return 0;

        return (current % 2 != 0 ? 1 : 0) + solveHelper(scanner);
    }
}
