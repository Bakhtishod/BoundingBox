class Circle extends Shape {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public Coordinate getBBCoordinates() {
        return new Coordinate(x - radius, y - radius, x + radius, y + radius);
    }
}
