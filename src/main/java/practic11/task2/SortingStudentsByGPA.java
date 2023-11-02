package practic11.task2;

import java.util.Arrays;

public class SortingStudentsByGPA {

    public static void main(String[] args) {
        Student[] students = {
                new Student("f", 6, 6),
                new Student("e", 5, 5),
                new Student("d", 4, 4),
                new Student("c", 3, 3),
                new Student("b", 2, 2),
                new Student("a", 1, 1),
        };

        quickSort(students, 0, students.length - 1);

        Arrays.stream(students).forEach(System.out::println);
    }

    private static <T extends Comparable<T>> void quickSort(T[] elements, int low, int high) {
        if (elements.length == 0)
            return;

        if (low >= high)
            return;

        int mid = low + (high - low) / 2;
        T support = elements[mid];

        int i = low;
        int j = high;

        while (i <= j) {
            while (elements[i].compareTo(support) < 0) {
                ++i;
            }

            while (elements[j].compareTo(support) > 0) {
                --j;
            }

            if (i <= j) {
                T temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
                ++i;
                --j;
            }
        }

        if (low < j) {
            quickSort(elements, low, j);
        }

        if (high > i) {
            quickSort(elements, i, high);
        }
    }
}
