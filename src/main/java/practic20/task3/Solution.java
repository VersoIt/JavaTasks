package practic20.task3;

import practic20.task2.domain.Calculator;
import practic20.task2.domain.Calculator32;

public class Solution {
    public static void main(String[] args) {
        Calculator<Float> calculator = new Calculator32();

        test(calculator, "3+(2*3)", "9.0");
        test(calculator, "1+(2-3)", "0.0");
        test(calculator, "3+(2*3)+10+23-3/10", "41.7");

        System.out.println("Tests passed!");
    }

    private static void test(Calculator<Float> calculator, String expression, String result) {
        if (!calculator.calculate(expression).toString().equals(result))
            throw new AssertionError();
    }
}
