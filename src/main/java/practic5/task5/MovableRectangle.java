package practic5.task5;

public class MovableRectangle implements Movable, Rectangle {

    private final Movable topLeftMovablePoint;

    private final Movable bottomRightMovablePoint;

    private final Point topLeftPoint;

    private final Point bottomRightPoint;

    public MovableRectangle(
            Point topLeftPoint, Movable topLeftMovablePoint, Point bottomRightPoint, Movable bottomRightMovablePoint
    ) {
        this.topLeftMovablePoint = topLeftMovablePoint;
        this.bottomRightMovablePoint = bottomRightMovablePoint;
        this.topLeftPoint = topLeftPoint;
        this.bottomRightPoint = bottomRightPoint;

        if (!pointsHaveSameSpeed()) {
            throw new IllegalArgumentException("Location points cannot have different speeds!");
        }
    }

    private boolean pointsHaveSameSpeed() {
        return topLeftMovablePoint.getXSpeed() == bottomRightMovablePoint.getXSpeed() &&
                topLeftMovablePoint.getYSpeed() == bottomRightMovablePoint.getYSpeed();
    }

    @Override
    public void moveUp() {
        topLeftMovablePoint.moveUp();
        bottomRightMovablePoint.moveUp();
    }

    @Override
    public void moveDown() {
        topLeftMovablePoint.moveDown();
        bottomRightMovablePoint.moveDown();
    }

    @Override
    public void moveRight() {
        topLeftMovablePoint.moveRight();
        bottomRightMovablePoint.moveRight();
    }

    @Override
    public void moveLeft() {
        topLeftMovablePoint.moveLeft();
        bottomRightMovablePoint.moveLeft();
    }

    @Override
    public int getXSpeed() {
        return Math.abs(topLeftMovablePoint.getXSpeed());
    }

    @Override
    public int getYSpeed() {
        return Math.abs(topLeftMovablePoint.getYSpeed());
    }

    @Override
    public Point getTopLeftMovable() {
        return topLeftPoint;
    }

    @Override
    public Point getBottomRightMovable() {
        return bottomRightPoint;
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeftMovablePoint=" + topLeftMovablePoint +
                ", bottomRightMovablePoint=" + bottomRightMovablePoint +
                ", topLeftPoint=" + topLeftPoint +
                ", bottomRightPoint=" + bottomRightPoint +
                '}';
    }
}
