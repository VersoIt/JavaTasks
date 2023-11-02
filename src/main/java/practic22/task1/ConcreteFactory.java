package practic22.task1;

public class ConcreteFactory implements ComplexAbstractFactory {

    @Override
    public Complex createComplex() {
        return new ComplexNumber(0, 0);
    }

    @Override
    public Complex createComplex(int real, int image) {
        return new ComplexNumber(image, real);
    }
}
