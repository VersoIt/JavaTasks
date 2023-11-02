package practic21.task1;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class CyclicQueue<T> implements Queue<T> {

    private int size;

    private int first;

    private int last;

    private final Object[] elements;

    public CyclicQueue(int capacity) {
        elements = new Object[capacity];

        first = -1;
        last = -1;
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
    public boolean contains(Object o) {
        int idxNum = first;
        int count = 0;

        while (count != size) {
            idxNum = (idxNum + 1) % elements.length;
            if (o.hashCode() == elements[idxNum].hashCode() && o.equals(elements[idxNum])) {
                return true;
            }
            ++count;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new CyclicQueueIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        int idxNum = first;
        int arrayIdxNum = 0;

        while (arrayIdxNum < size) {
            idxNum = (idxNum + 1) % elements.length;
            array[arrayIdxNum++] = elements[idxNum];
        }

        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] a) {
        return ((T1[]) toArray());
    }

    @Override
    public boolean add(T element) {
        return offer(element);
    }

    private boolean isEqual(Object current, Object other) {
        return current.hashCode() == other.hashCode() && current.equals(other);
    }

    @Override
    public boolean remove(Object other) {
        if (isEqual(elements[first], other)) {
            elements[first] = null;
            first = (first + 1) % elements.length;
            --size;
            return true;
        }

        int position = find(other);
        if (position == -1)
            return false;

        int idxNum = position;
        while (idxNum != first) {
            elements[idxNum] = elements[(idxNum - 1) % elements.length];
            idxNum = (idxNum - 1) % elements.length;
        }

        ++first;
        --size;

        return true;
    }

    private int find(Object element) {
        for (int i = 0; i < elements.length; ++i) {
            if (isEqual(element, elements[i]))
                return i;
        }

        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Set<Object> set = new HashSet<>(collection);
        AtomicInteger containsCount = new AtomicInteger();

        throughEntire(index -> {
            if (set.contains(elements[index]))
                containsCount.incrementAndGet();
        });

        return containsCount.get() == collection.size();
    }

    private void throughEntire(Consumer<Integer> consumer) {
        int length = elements.length;
        int idxNum = first;
        int count = 0;

        while (count != size) {
            consumer.accept(idxNum);
            idxNum = (idxNum + 1) % length;
            ++count;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> iterator = collection.iterator();

        while (iterator.hasNext() && size < elements.length) {
            offer(iterator.next());
        }

        return !iterator.hasNext();
    }

    private Map<Object, Integer> convertFromCollectionToCountMap(Collection<?> collection) {
        Map<Object, Integer> map = new HashMap<>();

        for (Object element : collection) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }

        return map;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        Map<Object, Integer> map = convertFromCollectionToCountMap(collection);

        int idxNum = first;
        int count = 0;

        boolean isRemoved = false;

        while (count < elements.length) {
            Object element = elements[idxNum];
            if (map.containsKey(element)) {
                if (map.get(element) == 1) {
                    map.remove(element);
                } else {
                    map.put(element, map.get(element) - 1);
                }
                remove(elements[idxNum]);
                isRemoved = true;
            }

            idxNum = (idxNum + 1) % elements.length;
            ++count;
        }

        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        Map<Object, Integer> map = convertFromCollectionToCountMap(collection);

        int idxNum = first;
        int count = 0;

        while (count < size) {
            Object element = elements[idxNum];
            if (map.containsKey(element)) {
                if (map.get(element) == 1) {
                    map.remove(element);
                } else {
                    map.put(element, map.get(element) - 1);
                }
            } else {
                remove(elements[idxNum]);
            }

            idxNum = (idxNum + 1) % elements.length;
            ++count;
        }

        return map.isEmpty();
    }

    @Override
    public void clear() {
        throughEntire(index ->
                elements[index] = null);

        first = -1;
        last = -1;
    }

    @Override
    public boolean offer(T element) {
        if (size <= elements.length) {
            if (first == -1 && last == -1)
                first++;

            elements[++last % elements.length] = element;
            ++size;
            return true;
        }

        return false;
    }

    @Override
    public T remove() {
        T removed = poll();
        if (removed == null)
            throw new EmptyQueueException();

        return removed;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T poll() {
        if (!isEmpty()) {
            if (first == 0 && last == 0) {
                first = -1;
                last = -1;
            } else {
                --size;
                first = (first + 1) % elements.length;
                return ((T) elements[first]);
            }
        }

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T element() {
        if (!isEmpty())
            return ((T) elements[first]);

        return null;
    }

    @Override
    public T peek() {
        return element();
    }

    static class EmptyQueueException extends RuntimeException {
    }

    private static class CyclicQueueIterator<T> implements Iterator<T> {

        private final CyclicQueue<T> queue;

        private int currentCount = 0;

        public CyclicQueueIterator(CyclicQueue<T> queue) {
            this.queue = queue;
        }

        @Override
        public boolean hasNext() {
            return currentCount != queue.size();
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) queue.elements[(queue.first + currentCount++) % queue.elements.length];
        }
    }
}
