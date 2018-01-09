package adventofcode.day3;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManhattanDistanceCalculatorTest {

    private SpiralMemoryList spiralMemoryList = new SpiralMemoryList(0);

    @Before
    public void setUp() {
        spiralMemoryList.addElement(9, 2, 2);
        spiralMemoryList.addElement(8, 1, 2);
        spiralMemoryList.addElement(7, 0, 2);
        spiralMemoryList.addElement(6, 0, 1);
        spiralMemoryList.addElement(5, 0, 0);
        spiralMemoryList.addElement(4, 1, 0);
        spiralMemoryList.addElement(3, 2, 0);
        spiralMemoryList.addElement(2, 2, 1);
        spiralMemoryList.addElement(1, 1, 1);
    }

    @Test
    public void calculate() {
        assertThat(new ManhattanDistanceCalculator().calculate(1, spiralMemoryList)).isEqualTo(0);
        assertThat(new ManhattanDistanceCalculator().calculate(2, spiralMemoryList)).isEqualTo(1);
        assertThat(new ManhattanDistanceCalculator().calculate(3, spiralMemoryList)).isEqualTo(2);
        assertThat(new ManhattanDistanceCalculator().calculate(4, spiralMemoryList)).isEqualTo(1);
        assertThat(new ManhattanDistanceCalculator().calculate(5, spiralMemoryList)).isEqualTo(2);
        assertThat(new ManhattanDistanceCalculator().calculate(6, spiralMemoryList)).isEqualTo(1);
        assertThat(new ManhattanDistanceCalculator().calculate(7, spiralMemoryList)).isEqualTo(2);
        assertThat(new ManhattanDistanceCalculator().calculate(8, spiralMemoryList)).isEqualTo(1);
        assertThat(new ManhattanDistanceCalculator().calculate(9, spiralMemoryList)).isEqualTo(2);
    }
}