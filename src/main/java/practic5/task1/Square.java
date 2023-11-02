package practic5.task1;

class Square extends Shape {

    private final int width;

    public Square(int width, String color) {
        super(color);
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    int getArea() {
        return width * width;
    }
}
