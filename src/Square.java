class Square extends Shape {
    private double side;

    public Square(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }

    @Override
    public Coordinate getBBCoordinates() {
        return new Coordinate(x - side / 2, y - side / 2, x + side / 2, y + side / 2);
    }
}
