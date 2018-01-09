package adventofcode.day3;

class SpiralMemorySquare extends SpiralMemory {

    private int[][] spiral;

    public SpiralMemorySquare(Integer squareLevel) {
        spiral = new int[squareLevel][squareLevel];
        create(squareLevel);
    }

    @Override
    protected void addElement(int value, int column, int row) {
        spiral[column][row] = value;
    }

    void print() {
        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral[i].length; j++) {
                System.out.print(spiral[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
