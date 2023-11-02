package practic21.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Queue<Integer> queue = new CyclicQueue<>(5);
        queue.addAll(list);

        for (Integer e : queue) {
            System.out.println(e);
        }

        System.out.println(Arrays.toString(queue.toArray()));

        System.out.println();

        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(5);

        queue.retainAll(a);

        for (Integer e : queue) {
            System.out.println(e);
        }
    }
}
