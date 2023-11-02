package practic18.task5;

public class Test {

    public static void main(String[] args) {
        Matrix<Integer> first = new Matrix2D<>(2, 2);
        Matrix<Integer> second = new Matrix2D<>(3, 2);

        first.set(0, 0, 3);
        first.set(1, 0, 5);
        first.set(0, 1, 2);
        first.set(1, 1, 1);

        second.set(0, 0, 8);
        second.set(1, 0, 2);
        second.set(2, 0, 3);
        second.set(0, 1, 1);
        second.set(1, 1, 7);
        second.set(2, 1, 2);

        System.out.println("first: ");
        System.out.println(first);
        System.out.println("second: ");
        System.out.println(second);

        System.out.println("result: ");
        System.out.println(first.product(second));
    }
}
