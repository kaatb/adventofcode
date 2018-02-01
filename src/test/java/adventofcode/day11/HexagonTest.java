package adventofcode.day11;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HexagonTest {

    @Test
    public void getMaxStepsFromCenter() {
        assertThat(new Hexagon(0, 0).getMaxStepsFromCenter()).isEqualTo(0);
        assertThat(new Hexagon(0, 2).getMaxStepsFromCenter()).isEqualTo(2);
        assertThat(new Hexagon(3, 2).getMaxStepsFromCenter()).isEqualTo(3);
        assertThat(new Hexagon(-3, 2).getMaxStepsFromCenter()).isEqualTo(3);
        assertThat(new Hexagon(-3, -5).getMaxStepsFromCenter()).isEqualTo(5);
    }
}