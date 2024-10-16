abstract class Shape {
    protected double x, y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract Coordinate getBBCoordinates();

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", minX=" + getBBCoordinates().minX +
                ", minY=" + getBBCoordinates().minY +
                ", maxX=" + getBBCoordinates().maxX +
                ", maxY=" + getBBCoordinates().maxY +
                '}';
    }
}
