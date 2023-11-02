package practic20.task2.domain;

public interface Calculator<T extends Number> {

    T calculate(String expression);
}
