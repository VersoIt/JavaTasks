package practic9.task1;

public class Main {
    public static void main(String[] args) {
        Nameable nameable = new Car("Bugatti");
        Nameable nameable1 = new Planet("Saturn");

        System.out.println(nameable.getName());
        System.out.println(nameable1.getName());
    }
}