package adventofcode.day3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralMemoryListTest {

    private static final SpiralMemoryElement ELEMENT_9 = new SpiralMemoryElement(9, 2, 2);
    private static final SpiralMemoryElement ELEMENT_8 = new SpiralMemoryElement(8, 2, 1);

    @Test
    public void findElement() {
        SpiralMemoryList spiralMemoryList = new SpiralMemoryList(0);
        spiralMemoryList.addElement(ELEMENT_9.getValue(), ELEMENT_9.getColumn(), ELEMENT_9.getRow());
        spiralMemoryList.addElement(ELEMENT_8.getValue(), ELEMENT_8.getColumn(), ELEMENT_8.getRow());

        assertThat(spiralMemoryList.findElement(9)).isEqualToComparingFieldByField(ELEMENT_9);
        assertThat(spiralMemoryList.findElement(8)).isEqualToComparingFieldByField(ELEMENT_8);
    }
}