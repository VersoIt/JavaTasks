package practic22.task1;

public record ComplexNumber(int image, int real) implements Complex {

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "image=" + image +
                ", real=" + real +
                '}';
    }
}
