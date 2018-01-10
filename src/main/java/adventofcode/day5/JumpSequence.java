package adventofcode.day5;

import java.util.List;
import java.util.stream.Collectors;

class JumpSequence {

    List<Integer> jumpSequence;

    JumpSequence(List<String> jumps) {
        jumpSequence = jumps.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int size() {
        return jumpSequence.size();
    }

    public Integer get(Integer index) {
        return jumpSequence.get(index);
    }

    public void set(Integer index, Integer newValue) {
        jumpSequence.set(index, newValue);
    }
}
