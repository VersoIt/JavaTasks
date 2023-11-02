package practic19.task2;

public class SuperClass {

    private final Object[] elements;

    private final int size;

    public SuperClass(int size) {
        this.size = size;
        elements = new Object[size];
    }

    public void set(int index, Object element) {
        elements[index] = element;
    }

    public Object get(int index) {
        return elements[index];
    }

    public int getSize() {
        return size;
    }
}
