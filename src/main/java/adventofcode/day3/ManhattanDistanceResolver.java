package adventofcode.day3;

class ManhattanDistanceResolver {

    public int resolve(Integer squareInput) {
//        SpiralMemorySquare spiralMemorySquare = new SpiralMemorySquare(calculateSpiralMemorySize(squareInput));

        SpiralMemoryList spiralMemoryList = new SpiralMemoryList(calculateSpiralMemorySize(squareInput));
        return new ManhattanDistanceCalculator().calculate(squareInput, spiralMemoryList);
    }

    private int calculateSpiralMemorySize(Integer squareInput) {
        return (int) (Math.ceil(Math.sqrt(squareInput)));
    }
}
