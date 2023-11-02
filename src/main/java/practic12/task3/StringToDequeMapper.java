package practic12.task3;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringToDequeMapper implements StringToCollectionMapper<Integer, Deque<Integer>> {

    @Override
    public Deque<Integer> convert(String target) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (char symbol : target.toCharArray()) {
            deque.add(symbol - '0');
        }

        return deque;
    }
}
