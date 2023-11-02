package practic18.task4;

public class MinMax<T extends Comparable<T>> {

    private final T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    public T min() {
        T result = array[0];
        for (int idxNum = 1; idxNum < array.length; ++idxNum) {
            if (array[idxNum].compareTo(result) < 0)
                result = array[idxNum];
        }
        return result;
    }

    public T max() {
        T result = array[0];
        for (int idxNum = 1; idxNum < array.length; ++idxNum) {
            if (array[idxNum].compareTo(result) > 0)
                result = array[idxNum];
        }
        return result;
    }
}
