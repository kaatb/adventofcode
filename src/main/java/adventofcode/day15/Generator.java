package adventofcode.day15;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class Generator {

    private static final Long DIVIDER = 2147483647L;

    private List<Long> values = newArrayList();
    private Long factor;
    private Long requirement;

    public Generator(Long factor, Long requirement, Long initialValue) {
        this.factor = factor;
        this.requirement = requirement;
        this.values.add(initialValue);
    }

    public Long nextValue() {
        Long nextValue = (values.get(values.size() - 1) * factor) % DIVIDER;
        values.add(nextValue);
        return nextValue;
    }

    public Long generateNextValueMeetingRequirement() {
        Long nextValue = nextValue();
        if (nextValue % requirement == 0) {
            return nextValue;
        } else {
            return generateNextValueMeetingRequirement();
        }
    }

    public List<Long> getValues() {
        return values;
    }
}
