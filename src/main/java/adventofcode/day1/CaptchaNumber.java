package adventofcode.day1;

class CaptchaNumber {

    private int originalValue;
    private int valueToCompareWith;

    CaptchaNumber(int originalValue, int valueToCompareWith) {
        this.originalValue = originalValue;
        this.valueToCompareWith = valueToCompareWith;
    }

    boolean shouldBeAdded() {
        return originalValue == valueToCompareWith;
    }

    int getValue() {
        return originalValue;
    }
}
