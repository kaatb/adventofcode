package adventofcode.day1;

public class CaptchaNumber {

    private int originalValue;
    private int valueToCompareWith;

    public CaptchaNumber(int originalValue, int valueToCompareWith) {
        this.originalValue = originalValue;
        this.valueToCompareWith = valueToCompareWith;
    }

    public boolean shouldBeAdded() {
        return originalValue == valueToCompareWith;
    }

    public int getValue() {
        return originalValue;
    }
}
