package practic21.task2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        for (Integer e : queue) {
            System.out.println(e);
        }

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
