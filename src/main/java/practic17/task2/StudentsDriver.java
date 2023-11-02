package practic17.task2;

import java.util.ArrayList;
import java.util.List;

public class StudentsDriver {

    public void mergeSort(List<Student> students) {
        if (students.size() < 2) {
            return;
        }

        List<Student> left = new ArrayList<>();
        List<Student> right = new ArrayList<>();

        int mid = students.size() / 2;

        for (int idxNum = 0; idxNum < mid; ++idxNum) {
            left.add(students.get(idxNum));
        }

        for (int idxNum = 0; idxNum < students.size() / 2; ++idxNum) {
            right.add(students.get(idxNum + mid));
        }

        mergeSort(left);
        mergeSort(right);

        merge(students, left, right);
    }

    private void merge(List<Student> target, List<Student> first, List<Student> second) {
        int firstIndex = 0;
        int secondIndex = 0;

        int targetIndex = 0;

        while (firstIndex < first.size() && secondIndex < second.size()) {
            if (first.get(firstIndex).getScore() < second.get(secondIndex).getScore()) {
                target.set(targetIndex++, first.get(firstIndex++));
            }
            else {
                target.set(targetIndex++, second.get(secondIndex++));
            }
        }

        while (firstIndex < first.size()) {
            target.set(targetIndex++, first.get(firstIndex++));
        }

        while (secondIndex < second.size()) {
            target.set(targetIndex++, second.get(secondIndex++));
        }
    }
}
