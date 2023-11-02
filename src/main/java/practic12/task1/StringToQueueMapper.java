package practic12.task1;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringToQueueMapper implements StringToCollectionMapper<Integer, Queue<Integer>> {

    @Override
    public Queue<Integer> convert(String target) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (char symbol : target.toCharArray()) {
            queue.add(symbol - '0');
        }

        return queue;
    }
}
