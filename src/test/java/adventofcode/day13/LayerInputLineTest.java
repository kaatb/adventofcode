package adventofcode.day13;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LayerInputLineTest {

    @Test
    public void getDepth() {
        assertThat(new LayerInputLine("0: 3").getDepth()).isEqualTo(0L);
        assertThat(new LayerInputLine("98: 18").getDepth()).isEqualTo(98L);
    }

    @Test
    public void getRange() {
        assertThat(new LayerInputLine("0: 3").getRange()).isEqualTo(3L);
        assertThat(new LayerInputLine("98: 18").getRange()).isEqualTo(18L);
    }
}