package practic23;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> root;

    private Node<T> last;

    private int size;

    public LinkedList() {
        root = null;
        size = 0;
    }

    public boolean add(T value) {
        if (root == null) {
            root = new Node<>(value);
            last = root;
        } else {
            last.next = new Node<>(value);
            last.next.previous = last;
            last = last.next;
        }
        ++size;
        return true;
    }

    public T get(int index) {
        AtomicReference<Node<T>> result = new AtomicReference<>(null);

        if ((float) index / size >= 0.5f) {
            throughEntireBackward((node, currentIndex) -> {
                if (currentIndex == index) {
                    result.set(node);
                    return true;
                }

                return false;
            });
        } else {
            throughEntireForward((node, currentIndex) -> {
                if (currentIndex == index) {
                    result.set(node);
                    return true;
                }

                return false;
            });
        }

        return result.get().value;
    }

    public int size() {
        return size;
    }

    public boolean removeAllBy(Function<T, Boolean> consumer) {
        boolean isDeleted = false;

        Node<T> dummy = new Node<>(null);
        Node<T> prev = dummy;
        Node<T> current = root;

        dummy.next = root;

        while (current != null) {
            if (consumer.apply(current.value)) {
                prev.next = current.next;

                if (current.next != null)
                    current.next.previous = prev;

                isDeleted = true;
            }

            prev = current;
            current = current.next;
        }

        root = dummy.next;

        return isDeleted;
    }

    public int sumBy(Function<T, Integer> consumer) {
        AtomicInteger result = new AtomicInteger(0);

        throughEntireForward((node, index) -> {
            result.addAndGet(consumer.apply(node.value));
            return false;
        });

        return result.get();
    }

    @SuppressWarnings("unchecked")
    public void sort() {
        Object[] array = toArray();
        Arrays.sort(array);

        throughEntireForward((node, index) -> {
            node.setValue((T) array[index]);
            return false;
        });
    }

    @SuppressWarnings("unchecked")
    public void sortDescending() {
        Object[] array = toArray();
        Arrays.sort(array);

        throughEntireBackward((node, index) -> {
            node.setValue((T) array[size - index - 1]);
            return false;
        });
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;

        for (Object item : this) {
            array[index++] = item;
        }

        return array;
    }

    private boolean areSame(Object current, Object other) {
        return current.hashCode() == other.hashCode() && current.equals(other);
    }

    private void throughEntireForward(LinkedConsumer<Node<T>, Integer> consumer) {
        Node<T> current = root;
        int index = 0;

        while (current != null) {
            if (consumer.apply(current, index++)) {
                return;
            }

            current = current.next;
        }
    }

    private void throughEntireBackward(LinkedConsumer<Node<T>, Integer> consumer) {
        Node<T> current = last;
        int index = size - 1;

        while (current != null) {
            if (consumer.apply(current, index--)) {
                return;
            }

            current = current.previous;
        }
    }

    public boolean remove(T value) {
        if (value == null)
            return false;

        if (root != null && areSame(root.value, value)) {
            root = root.next;
            root.next.previous = root;
            return true;
        }

        Node<T> dummy = new Node<>(null);
        AtomicReference<Node<T>> prev = new AtomicReference<>(dummy);

        dummy.previous = last;

        throughEntireBackward((node, index) -> {
            if (areSame(value, node.value)) {
                prev.get().previous = node.previous;

                if (node.previous != null)
                    node.previous.next = prev.get();

                --size;
                return true;
            }

            prev.set(node);
            return false;
        });

        last = dummy.previous;
        last.next = null;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(root);
    }

    private static class Node<T> {

        private T value;

        private Node<T> next;

        private Node<T> previous;

        public Node(T value) {
            this(value, null);
        }

        public Node(T value, Node<T> next) {
            this(value, next, null);
        }

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
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

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }

    @FunctionalInterface
    private interface LinkedConsumer<T, R> {
        boolean apply(T t, R r);
    }

    private static class LinkedListIterator<T> implements Iterator<T> {

        private Node<T> current;

        public LinkedListIterator(Node<T> root) {
            current = root;
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
            current = current.next;
            return value;
        }
    }
}
