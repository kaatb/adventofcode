package adventofcode.day3;

class ManhattanDistanceCalculator {

    public int calculate(Integer value, SpiralCountingMemory spiralMemoryList) {
        SpiralMemoryElement elementWithValue = spiralMemoryList.findElementWithValue(value);
        SpiralMemoryElement element1 = spiralMemoryList.findElementWithValue(1);

        return Math.abs(elementWithValue.getColumn() - element1.getColumn()) + Math.abs(elementWithValue.getRow() - element1.getRow());
    }
}
