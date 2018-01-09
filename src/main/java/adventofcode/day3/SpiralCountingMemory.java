package adventofcode.day3;

public class SpiralCountingMemory extends SpiralMemoryList {

    SpiralCountingMemory(Integer maxValue) {
        createUntil(maxValue);
    }

    @Override
    protected int getNextValue(int row, int column) {
        return elements.get(elements.size() - 1).getValue() + 1;
    }

}
