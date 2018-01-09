package adventofcode.day3;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

abstract class SpiralMemoryList {

    protected List<SpiralMemoryElement> elements = Lists.newArrayList();

    protected void createUntil(Integer maxValue) {
        int nextValue = 1;
        int minColumn = 0;
        int minRow = -1;
        int maxColumn = 1;
        int maxRow = 0;

        elements.add(new SpiralMemoryElement(nextValue, 0, 0));
        nextValue = getNextValue(0, 1);
        elements.add(new SpiralMemoryElement(nextValue, 0, 1));

        while (nextValue <= maxValue) {
            minColumn--;
            // left
            for (int i = maxColumn; i > minColumn; i--) {
                nextValue = getNextValue(minRow, i);
                elements.add(new SpiralMemoryElement(nextValue, minRow, i));
            }

            maxRow++;
            //down
            for (int i = minRow; i < maxRow; i++) {
                nextValue = getNextValue(i, minColumn);
                elements.add(new SpiralMemoryElement(nextValue, i, minColumn));
            }

            maxColumn++;
            // right
            for (int i = minColumn; i < maxColumn; i++) {
                nextValue = getNextValue(maxRow, i);
                elements.add(new SpiralMemoryElement(nextValue, maxRow, i));
            }

            minRow--;
            // up
            for (int i = maxRow; i > minRow; i--) {
                nextValue = getNextValue(i, maxColumn);
                elements.add(new SpiralMemoryElement(nextValue, i, maxColumn));
            }
        }
    }

    protected abstract int getNextValue(int row, int column);

    public SpiralMemoryElement findElement(Integer row, Integer column) {
        List<SpiralMemoryElement> matchingElements = elements.stream()
                .filter(element -> (element.getRow().equals(row) && element.getColumn().equals(column)))
                .collect(Collectors.toList());
        if (matchingElements.size() != 1) {
            throw new IllegalStateException("Illegal number of elements found");
        } else {
            return matchingElements.get(0);
        }
    }

    public SpiralMemoryElement findElementWithValue(int value) {
        return elements.stream()
                .filter(element -> element.getValue() == value)
                .findFirst()
                .get();
    }

    public int findElementWithValueBiggerThan(int value) {
        return elements.stream()
                .filter(element -> element.getValue() > value)
                .sorted(Comparator.comparingInt(SpiralMemoryElement::getValue))
                .findFirst()
                .get()
                .getValue();
    }
}
