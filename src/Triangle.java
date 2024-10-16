class Triangle extends Shape {
    private double side;

    public Triangle(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }

    @Override
    public Coordinate getBBCoordinates() {
        double height = (Math.sqrt(3) / 2) * side;
        return new Coordinate(x - side / 2, y - height / 3, x + side / 2, y + 2 * height / 3);
    }
}
