package practic20.task1;

import java.util.HashMap;
import java.util.Stack;

public class PolishNotationCalculator implements Calculator<Float> {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final HashMap<Character, Operation<Float>> operations;

    public PolishNotationCalculator() {
        operations = new HashMap<>() {
            {
                put('*', (x, y) -> x * y);
                put('/', (x, y) -> x / y);
                put('+', Float::sum);
                put('-', (x, y) -> x - y);
            }
        };
    }

    @Override
    public Float calculate(String expression) {
        int expressionIndex = 0;

        Stack<Float> stack = new Stack<>();

        while (expressionIndex < expression.length()) {

            Float currentNumber = null;
            while (Character.isDigit(expression.charAt(expressionIndex))) {
                currentNumber = (currentNumber == null ? 0 : currentNumber) * 10 + (expression.charAt(expressionIndex) - '0');
                ++expressionIndex;
            }

            if (currentNumber != null)
                stack.add(currentNumber);

            Operation<Float> operation = operations.get(expression.charAt(expressionIndex));
            if (operation != null) {
                float second = stack.pop();
                float first = stack.pop();

                stack.add(operation.invoke(first, second));
            }

            ++expressionIndex;
        }

        return stack.pop();
    }

    interface Operation<T extends Number> {

        T invoke(T first, T second);
    }
}
