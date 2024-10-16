class Hexagon extends Shape {
    private double side;

    public Hexagon(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }

    @Override
    public Coordinate getBBCoordinates() {
        double height = (Math.sqrt(3) / 2) * side;
        return new Coordinate(x - height, y - side, x + height, y + side);
    }
}
