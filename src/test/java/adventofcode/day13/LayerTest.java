package adventofcode.day13;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LayerTest {

    @Test
    public void scan() {
        Layer layer = new Layer(0L, 3L);

        assertThat(layer.getSecurityScanner()).isEqualTo(0L);

        layer.scan();
        assertThat(layer.getSecurityScanner()).isEqualTo(1L);

        layer.scan();
        assertThat(layer.getSecurityScanner()).isEqualTo(2L);

        layer.scan();
        assertThat(layer.getSecurityScanner()).isEqualTo(1L);

        layer.scan();
        assertThat(layer.getSecurityScanner()).isEqualTo(0L);

        layer.scan();
        assertThat(layer.getSecurityScanner()).isEqualTo(1L);

        layer.scan();
        assertThat(layer.getSecurityScanner()).isEqualTo(2L);
    }
}