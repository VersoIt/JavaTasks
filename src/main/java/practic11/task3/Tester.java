package practic11.task3;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {

        Student[] firstStudents = {
                new Student("c", 3, 3),
                new Student("b", 2, 2),
                new Student("a", 1, 1),
                new Student("a", 1, 5),
                new Student("a", 1, 2),

        };

        Student[] secondStudents = {
                new Student("b", 2, 3),
                new Student("a", 1, 1000),
                new Student("a", 1, -6),
                new Student("a", 1, 1),
        };

        Arrays.stream(mergeSort(firstStudents, secondStudents)).forEach(System.out::println);
    }

    public static Student[] mergeSort(Student[] first, Student[] second) {
        Student[] result = new Student[first.length + second.length];

        mergeSort(first);
        mergeSort(second);

        merge(result, first, second);

        mergeSort(result);

        return result;
    }

    public static void mergeSort(Student[] array) {
        if (array.length < 2)
            return;

        int mid = array.length / 2;

        Student[] left = new Student[mid];
        Student[] right = new Student[array.length - mid];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(Student[] target, Student[] first, Student[] second) {
        int firstIndex = 0;
        int secondIndex = 0;

        int targetIndex = 0;

        while (firstIndex < first.length) {
            if (secondIndex < second.length && second[secondIndex].compareTo(first[firstIndex]) < 0) {
                target[targetIndex++] = second[secondIndex++];
            } else {
                target[targetIndex++] = first[firstIndex++];
            }
        }

        while (secondIndex < second.length) {
            target[targetIndex++] = second[secondIndex++];
        }
    }
}
