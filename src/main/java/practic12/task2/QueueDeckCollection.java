package practic12.task2;

import java.util.Queue;

public class QueueDeckCollection implements DeckCollection<Integer> {

    private final Queue<Integer> queue;

    public QueueDeckCollection(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void add(Integer element) {
        queue.add(element);
    }

    @Override
    public Integer get() {
        return queue.poll();
    }

    @Override
    public int getLength() {
        return queue.size();
    }
}
