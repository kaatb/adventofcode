package adventofcode.day6;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryReallocationResultTest {

    @Test
    public void getLoopSize() {
        MemoryReallocationResult memoryReallocationResult = new MemoryReallocationResult();
        memoryReallocationResult.addHistory(Arrays.asList(0));
        memoryReallocationResult.addHistory(Arrays.asList(1));
        memoryReallocationResult.addHistory(Arrays.asList(0));

        assertThat(memoryReallocationResult.getLoopSize()).isEqualTo(2);
    }
}