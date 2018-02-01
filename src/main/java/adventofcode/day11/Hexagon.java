package adventofcode.day11;

class Hexagon {

    private int coordinateX;
    private int coordinateY;

    Hexagon(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int getMaxStepsFromCenter() {
        return Math.max(Math.abs(getCoordinateX()), Math.abs(getCoordinateY()));
    }
}
