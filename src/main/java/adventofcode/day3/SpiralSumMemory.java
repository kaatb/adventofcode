package adventofcode.day3;

import java.util.List;
import java.util.stream.Collectors;

public class SpiralSumMemory extends SpiralMemoryList {

    SpiralSumMemory(Integer maxValue) {
        createUntil(maxValue);
    }

    @Override
    protected int getNextValue(int row, int column) {
        int nextValue;
        nextValue = findElementsAdjacentTo(row, column)
                .stream()
                .mapToInt(SpiralMemoryElement::getValue)
                .reduce(0, (a, b) -> a + b);
        return nextValue;
    }

    private List<SpiralMemoryElement> findElementsAdjacentTo(Integer row, Integer column) {
        return elements.stream()
                .filter(element -> (element.getRow().equals(row) || element.getRow().equals(row - 1) || element.getRow().equals(row + 1))
                        && (element.getColumn().equals(column) || element.getColumn().equals(column - 1) || element.getColumn().equals(column + 1)))
                .collect(Collectors.toList());
    }
}
