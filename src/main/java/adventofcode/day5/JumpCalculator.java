package adventofcode.day5;

import java.util.function.Function;

public class JumpCalculator {

    int calculate(JumpSequence jumpSequence, Function<Integer, Integer> jumpChangeFunction) {
        int numberOfJumps = 0;
        int nextIndex = 0;
        while (nextIndex >= 0 && nextIndex < jumpSequence.size()) {
            Integer currentIndex = nextIndex;
            Integer currentJump = jumpSequence.get(currentIndex);
            nextIndex = currentIndex + currentJump;
            jumpSequence.set(currentIndex, jumpChangeFunction.apply(currentJump));
            numberOfJumps++;
        }
        return numberOfJumps;
    }
}
