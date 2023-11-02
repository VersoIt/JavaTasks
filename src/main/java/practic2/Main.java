package practic2;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int sum = 0;

        for (int j : array) {
            sum += j;
        }
        System.out.println(sum);
    }
}
