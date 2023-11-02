package practic19.task2;

public class Test {

    public static void main(String[] args) {
        SuperClass superClass = new SuperClass(10);
        superClass.set(0, "first");
        superClass.set(1, 12);
        superClass.set(2, 12.3);

        for (int i = 0; i < superClass.getSize(); ++i) {
            System.out.println(superClass.get(i));
        }
    }
}
