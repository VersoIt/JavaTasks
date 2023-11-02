package practic20.task1;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        Calculator<Float> calculator = new PolishNotationCalculator();
        System.out.println(calculator.calculate(expression));
    }
}