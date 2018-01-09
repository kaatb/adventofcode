package adventofcode.day3;

class SpiralMemoryElement {

    private final Integer value;
    private final Integer row;
    private final Integer column;

    SpiralMemoryElement(Integer value, Integer row, Integer column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getRow() {
        return row;
    }
}
