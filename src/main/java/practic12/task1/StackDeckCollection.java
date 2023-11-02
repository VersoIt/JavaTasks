package practic12.task1;

import java.util.Stack;

public class StackDeckCollection implements DeckCollection<Integer> {

    private Stack<Integer> stack;

    public StackDeckCollection(Stack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public void add(Integer element) {
        Stack<Integer> newStack = new Stack<Integer>();

        newStack.add(element);
        newStack.addAll(stack);

        this.stack = newStack;
    }

    @Override
    public Integer get() {
        return stack.pop();
    }

    @Override
    public int getLength() {
        return stack.size();
    }
}
