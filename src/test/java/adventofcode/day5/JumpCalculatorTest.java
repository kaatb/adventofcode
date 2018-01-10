package adventofcode.day5;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JumpCalculatorTest {

    @Test
    public void resolve_add1ToEachJump() {
        JumpSequence jumpSequence = new JumpSequence(Arrays.asList("0", "3", "0", "1", "-3"));
        assertThat(new JumpCalculator().calculate(jumpSequence, Jumps.increaseBy1())).isEqualTo(5);
    }

    @Test
    public void resolve_add1IfJumpIsLessThan3OrDecrease1IfJumpIs3OrHigherToEachJump() {
        JumpSequence jumpSequence = new JumpSequence(Arrays.asList("0", "3", "0", "1", "-3"));
        assertThat(new JumpCalculator().calculate(jumpSequence, Jumps.increaseOrDecreaseBy1())).isEqualTo(10);
    }

}