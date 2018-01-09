package adventofcode.day3;

import com.google.common.collect.Lists;

import java.util.List;

class SpiralMemoryList extends SpiralMemory {

    private List<SpiralMemoryElement> elements = Lists.newArrayList();

    SpiralMemoryList(Integer squareLevel) {
        create(squareLevel);
    }

    @Override
    protected void addElement(int value, int column, int row) {
        elements.add(new SpiralMemoryElement(value, row, column));
    }

    public SpiralMemoryElement findElement(Integer value) {
        return elements.stream()
                .filter(element -> element.getValue().equals(value))
                .findFirst()
                .get();
    }
}
