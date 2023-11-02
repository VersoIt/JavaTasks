package practic11.task1;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Student[] students = {
                new Student(1, "a"),
                new Student(3, "c"),
                new Student(2, "b"),
                new Student(4, "d"),
                new Student(5, "e"),
                new Student(8, "h"),
                new Student(9, "i"),
                new Student(0, "k"),
                new Student(6, "f"),
                new Student(7, "g")
        };

        insertionSort(students);

        Arrays.stream(students).forEach(System.out::println);

    }

    private static <T extends Comparable<T>> void insertionSort(T[] elements) {
        for (int i = 1; i < elements.length; ++i) {
            T key = elements[i];
            int j = i - 1;
            while (j >= 0 && key.compareTo(elements[j]) < 0) {
                elements[j + 1] = elements[j];
                --j;
            }
            elements[j + 1] = key;
        }
    }
}
