package practic18.task2;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        SomeClass<Integer, String, Date> someClass = new SomeClass<>(10, "October", new Date());
        someClass.printAllTypes();
    }
}
