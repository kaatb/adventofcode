package adventofcode.day10;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashCalculatorIntegrationTest {

    @Test
    public void knotHash() {
        assertThat(new HashCalculator().knotHash(""))
                .isEqualTo("a2582a3a0e66e6e86e3812dcb672a272");
        assertThat(new HashCalculator().knotHash("AoC 2017"))
                .isEqualTo("33efeb34ea91902bb2f59c9920caa6cd");
        assertThat(new HashCalculator().knotHash("1,2,3"))
                .isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d");
        assertThat(new HashCalculator().knotHash("1,2,4"))
                .isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e");
        assertThat(new HashCalculator().knotHash("flqrgnkx-2"))
                .isEqualTo("0adf13fa40e8ea815376776af3b7b231");
        assertThat(new HashCalculator().knotHash("flqrgnkx-3"))
                .isEqualTo("ad3da28cd7b8fb99742c0e63672caf62");
    }
}
