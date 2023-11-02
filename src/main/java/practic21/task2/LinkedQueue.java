package practic21.task2;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> first;

    private Node<T> last;

    private int size;

    public LinkedQueue() {
        first = null;
        last = null;

        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object other) {
        AtomicBoolean isFound = new AtomicBoolean(false);

        throughEntire((node, index) -> {
            if (areSame(node.value, (T) other)) {
                isFound.set(true);
                return true;
            }

            return false;
        });

        return isFound.get();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedQueueIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        throughEntire((node, index) -> {
            array[index] = node.value;
            return false;
        });

        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] array) {
        if (array.length != size)
            return array;

        throughEntire((node, index) -> {
            array[index] = (T1) node.value;
            return false;
        });

        return array;
    }

    @Override
    public boolean add(T element) {
        ++size;
        return offer(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object other) {
        Node<T> dummy = new Node<>(null);

        AtomicReference<Node<T>> prev = new AtomicReference<>(dummy);
        AtomicBoolean isRemoved = new AtomicBoolean(false);

        dummy.next = first;

        throughEntire((node, index) -> {
            if (areSame(node.value, (T) other)) {
                prev.get().next = node.next;
                isRemoved.set(true);
                return true;
            }

            prev.set(node);
            return false;
        });

        first = dummy.next;
        return isRemoved.get();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Map<Object, Integer> counts = getElementsCounts(collection);

        throughEntire((node, index) -> {
            if (counts.isEmpty()) {
                return true;
            }

            Object value = node.value;
            if (counts.containsKey(value)) {
                if (counts.get(value) == 1) {
                    counts.remove(value);
                } else {
                    counts.put(value, counts.get(value) - 1);
                }
            }

            return false;
        });

        return counts.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T element : collection) {
            offer(element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        Map<Object, Integer> counts = getElementsCounts(collection);

        throughEntire((node, index) -> {
            Object value = node.value;

            if (counts.containsKey(value)) {
                if (counts.get(value) == 1)
                    counts.remove(value);
                else
                    counts.put(value, counts.get(value) - 1);

                remove(value);
            }

            return counts.isEmpty();
        });

        return counts.isEmpty();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        Map<Object, Integer> counts = getElementsCounts(collection);
        int lastSize = counts.size();

        throughEntire((node, index) -> {
            T value = node.value;
            if (counts.containsKey(value)) {
                if (counts.get(value) == 1) {
                    counts.remove(value);
                } else {
                    counts.put(value, counts.get(value) - 1);
                }
            } else {
                remove(value);
            }

            return false;
        });

        return lastSize != counts.size();
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public boolean offer(T value) {
        if (first == null) {
            insertFirst(value);
        } else {
            last.next = new Node<>(value);
            last = last.next;
        }

        return true;
    }

    private void insertFirst(T value) {
        first = new Node<>(value);
        last = first;
    }

    @Override
    public T remove() {
        T element = poll();

        if (element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public T poll() {
        if (first == null)
            return null;

        --size;

        T element = first.value;
        first = first.next;
        return element;
    }

    @Override
    public T element() {
        T element = peek();

        if (element == null)
            throw new NoSuchElementException();

        return element;
    }

    @Override
    public T peek() {
        if (first == null)
            return null;

        return first.value;
    }

    private void throughEntire(Consumer<Node<T>, Integer> consumer) {
        Node<T> current = first;
        int index = 0;

        while (current != null) {
            if (consumer.apply(current, index))
                return;

            current = current.next;
            ++index;
        }
    }

    private boolean areSame(T current, T other) {
        return current.hashCode() == other.hashCode() && current.equals(other);
    }

    private Map<Object, Integer> getElementsCounts(Collection<?> collection) {
        Map<Object, Integer> counts = new HashMap<>();

        for (Object value : collection) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        return counts;
    }

    private static class Node<T> {

        private T value;

        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private static class LinkedQueueIterator<T> implements Iterator<T> {

        private Node<T> current;

        public LinkedQueueIterator(LinkedQueue<T> queue) {
            current = queue.first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null)
                throw new NoSuchElementException();

            T value = current.value;
            if (current.next != null)
                current = new Node<>(current.next.value, current.next.next);
            else
                current = null;

            return value;
        }
    }

    private interface Consumer<T, R> {

        boolean apply(T t, R r);
    }
}
