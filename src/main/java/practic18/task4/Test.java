package practic18.task4;

public class Test {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 5, 6, 7, 8, 100, -1, 0};
        MinMax<Integer> minMax = new MinMax<>(array);

        System.out.println(minMax.max());
        System.out.println(minMax.min());
    }
}
