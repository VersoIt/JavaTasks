package practic12.task4;

import java.util.Deque;

public class DequeDeckCollection implements DeckCollection<Integer> {

    private final Deque<Integer> deque;

    public DequeDeckCollection(Deque<Integer> deque) {
        this.deque = deque;
    }

    @Override
    public void add(Integer element) {
        deque.add(element);
    }

    @Override
    public Integer get() {
        return deque.poll();
    }

    @Override
    public int getLength() {
        return deque.size();
    }
}
