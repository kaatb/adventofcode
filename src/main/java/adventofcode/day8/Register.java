package adventofcode.day8;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Register {

    private final String name;
    private Integer value;

    public Register(String name) {
        this.name = name;
        this.value = 0;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void increase(int toIncreaseWith) {
        this.value += toIncreaseWith;
    }

    public void decrease(int toDecreaseWith) {
        this.value -= toDecreaseWith;
    }

    @Override
    public String toString() {
        return name + " -> " + value;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, "value");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "value");
    }
}
