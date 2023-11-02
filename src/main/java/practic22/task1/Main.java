package practic22.task1;

public class Main {

    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();

        System.out.println(factory.createComplex());
        System.out.println(factory.createComplex(2, 5));
    }
}
