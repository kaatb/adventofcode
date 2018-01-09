package adventofcode.day3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManhattanDistanceCalculatorTest {

    private SpiralCountingMemory spiral = new SpiralCountingMemory(9);

    @Test
    public void calculate() {
        assertThat(new ManhattanDistanceCalculator().calculate(1, spiral)).isEqualTo(0);
        assertThat(new ManhattanDistanceCalculator().calculate(2, spiral)).isEqualTo(1);
        assertThat(new ManhattanDistanceCalculator().calculate(3, spiral)).isEqualTo(2);
        assertThat(new ManhattanDistanceCalculator().calculate(4, spiral)).isEqualTo(1);
        assertThat(new ManhattanDistanceCalculator().calculate(5, spiral)).isEqualTo(2);
        assertThat(new ManhattanDistanceCalculator().calculate(6, spiral)).isEqualTo(1);
        assertThat(new ManhattanDistanceCalculator().calculate(7, spiral)).isEqualTo(2);
        assertThat(new ManhattanDistanceCalculator().calculate(8, spiral)).isEqualTo(1);
        assertThat(new ManhattanDistanceCalculator().calculate(9, spiral)).isEqualTo(2);
    }
}