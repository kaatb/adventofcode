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

    @Test
    public void willCatchIntruder() {
        Layer layer = new Layer(0L, 3L);

        assertThat(layer.willCatchIntruder(0L)).isTrue();
        assertThat(layer.willCatchIntruder(1L)).isFalse();
        assertThat(layer.willCatchIntruder(2L)).isFalse();
        assertThat(layer.willCatchIntruder(3L)).isFalse();
        assertThat(layer.willCatchIntruder(4L)).isTrue();
        assertThat(layer.willCatchIntruder(5L)).isFalse();
        assertThat(layer.willCatchIntruder(6L)).isFalse();
        assertThat(layer.willCatchIntruder(7L)).isFalse();
        assertThat(layer.willCatchIntruder(8L)).isTrue();
    }
}