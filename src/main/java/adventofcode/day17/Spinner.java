package adventofcode.day17;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Spinner {

    private final int numberOfSteps;

    Spinner(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public List<Value> spin(int times) {
        List<Value> allValues = newArrayList();
        Value firstValue = createFirstValue();
        allValues.add(firstValue);

        Value currentPosition = firstValue;
        for (int i = 1; i <= times; i++) {
            currentPosition = insertNewValueAfter(findPositionToInsertNewValueAfter(currentPosition), i);
            allValues.add(currentPosition);
        }

        return allValues;
    }

    public Integer findElementAtIndex1After(int times) {
        Integer valueAtIndex1 = null;

        int toInsertAtIndex = 0;
        for (int i = 1; i <= times; i++) {
            int toInsertAtIndexBasedForList = (toInsertAtIndex + numberOfSteps) % (i);
            if (toInsertAtIndexBasedForList == 0) {
                valueAtIndex1 = i;
            }
            toInsertAtIndex = toInsertAtIndexBasedForList + 1;
        }

        return valueAtIndex1;
    }

    private Value findPositionToInsertNewValueAfter(Value currentPosition) {
        for (int j = 0; j < numberOfSteps; j++) {
            currentPosition = currentPosition.getNextValue();
        }
        return currentPosition;
    }

    private Value insertNewValueAfter(Value currentPosition, int valueToInsert) {
        Value newValue = new Value(valueToInsert, currentPosition.getNextValue());
        currentPosition.setNextValue(newValue);
        return newValue;
    }

    private Value createFirstValue() {
        Value firstValue = new Value(0, null);
        firstValue.setNextValue(firstValue);
        return firstValue;
    }
}
