package practic12.task1;

import java.util.Stack;

public class StringToStackMapper implements StringToCollectionMapper<Integer, Stack<Integer>> {

    @Override
    public Stack<Integer> convert(String target) {
        Stack<Integer> stack = new Stack<>();

        for (int idxNum = target.length() - 1; idxNum >= 0; --idxNum) {
            stack.add(target.charAt(idxNum) - '0');
        }

        return stack;
    }
}
