package practic5.task5;

public class RectangleTester {

    public static void main(String[] args) {

        MovablePoint2D leftPoint = new MovablePoint2D(0, 0, 1, 1);
        MovablePoint2D rightPoint = new MovablePoint2D(10, 4, 1, 1);

        Movable rectangle = new MovableRectangle(leftPoint, leftPoint, rightPoint, rightPoint);
        System.out.println(rectangle);
    }
}
