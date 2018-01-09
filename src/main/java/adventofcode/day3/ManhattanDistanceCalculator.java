package adventofcode.day3;

class ManhattanDistanceCalculator {

    public int calculate(Integer value, SpiralMemoryList spiralMemoryList) {
        SpiralMemoryElement elementWithValue = spiralMemoryList.findElement(value);
        SpiralMemoryElement element1 = spiralMemoryList.findElement(1);

        return Math.abs(elementWithValue.getColumn() - element1.getColumn()) + Math.abs(elementWithValue.getRow() - element1.getRow());
    }
}
