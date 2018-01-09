package adventofcode.day3;

abstract class SpiralMemory {

    protected void create(Integer squareLevel) {
        int columnMax = squareLevel - 1;
        int rowMax = squareLevel - 1;
        int columnMin = 0;
        int rowMin = 0;
        int value = squareLevel * squareLevel;

        while (value > 0) {
            value = createRightToLeft(rowMax, rowMin, columnMax, value);
            columnMax--;

            value = createBottomToTop(columnMax, columnMin, rowMin, value);
            rowMin++;

            value = createLeftToRight(rowMin, rowMax, columnMin, value);
            columnMin++;

            value = createTopToBottom(columnMin, columnMax, rowMax, value);
            rowMax--;
        }
    }

    protected abstract void addElement(int value, int column, int row);

    private int createTopToBottom(int columnMin, int columnMax, int rowMax, int value) {
        for (int i = columnMin; i <= columnMax; i++) {
            addElement(value, i, rowMax);
            value--;
        }
        return value;
    }

    private int createLeftToRight(int rowMin, int rowMax, int columnMin, int value) {
        for (int i = rowMin; i <= rowMax; i++) {
            addElement(value, columnMin, i);
            value--;
        }
        return value;
    }

    private int createBottomToTop(int columnMax, int columnMin, int rowMin, int value) {
        for (int i = columnMax; i >= columnMin; i--) {
            addElement(value, i, rowMin);
            value--;
        }
        return value;
    }

    private int createRightToLeft(int rowMax, int rowMin, int columnMax, int value) {
        for (int i = rowMax; i >= rowMin; i--) {
            addElement(value, columnMax, i);
            value--;
        }
        return value;
    }
}
