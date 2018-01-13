package adventofcode.day8;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Register {

    private final String name;
    private Integer value = 0;
    private Integer maxValue = 0;

    public Register(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void increase(int toIncreaseWith) {
        value += toIncreaseWith;
        resetMaxValueIfNeeded();
    }

    private void resetMaxValueIfNeeded() {
        if (value > maxValue) {
            maxValue = value;
        }
    }

    public void decrease(int toDecreaseWith) {
        value -= toDecreaseWith;
        resetMaxValueIfNeeded();
    }

    @Override
    public String toString() {
        return name + " -> " + value;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, "value", "maxValue");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "value", "maxValue");
    }
}
