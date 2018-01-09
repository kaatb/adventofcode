package adventofcode.day3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralCountingMemoryTest {

    private static final SpiralMemoryElement ELEMENT_9 = new SpiralMemoryElement(9, 1, 1);
    private static final SpiralMemoryElement ELEMENT_8 = new SpiralMemoryElement(8, 1, 0);

    @Test
    public void findElementWithValue() {
        SpiralCountingMemory spiral = new SpiralCountingMemory(0);
        spiral.elements.add(ELEMENT_9);
        spiral.elements.add(ELEMENT_8);

        assertThat(spiral.findElementWithValue(9)).isEqualToComparingFieldByField(ELEMENT_9);
        assertThat(spiral.findElementWithValue(8)).isEqualToComparingFieldByField(ELEMENT_8);
    }

    @Test
    public void create() {
        SpiralCountingMemory spiral = new SpiralCountingMemory(9);

        assertThat(spiral.findElementWithValue(9)).isEqualToComparingFieldByField(ELEMENT_9);
        assertThat(spiral.findElementWithValue(8)).isEqualToComparingFieldByField(ELEMENT_8);
    }
}