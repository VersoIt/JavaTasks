package practic20.task1;

public interface Calculator<T extends Number> {

    T calculate(String expression);

}
