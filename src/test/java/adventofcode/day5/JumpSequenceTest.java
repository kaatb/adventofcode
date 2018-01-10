package adventofcode.day5;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JumpSequenceTest {

    @Test
    public void constructor() {
        assertThat(new JumpSequence(Arrays.asList("1", "2", "-3")).jumpSequence).containsExactly(1, 2, -3);
    }
}