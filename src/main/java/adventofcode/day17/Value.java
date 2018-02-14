package adventofcode.day17;

public class Value {

    private final int value;
    private Value nextValue;

    Value(int value, Value nextValue) {
        this.value = value;
        this.nextValue = nextValue;
    }

    public void setNextValue(Value nextValue) {
        this.nextValue = nextValue;
    }

    public Value getNextValue() {
        return nextValue;
    }

    public int getValue() {
        return value;
    }
}
