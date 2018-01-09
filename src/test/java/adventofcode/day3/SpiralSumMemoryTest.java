package adventofcode.day3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralSumMemoryTest {

    @Test
    public void create() {
        SpiralSumMemory spiralSumMemory = new SpiralSumMemory(800);

        assertThat(spiralSumMemory.findElement(-2, -2).getValue()).isEqualTo(147);
        assertThat(spiralSumMemory.findElement(-2, -1).getValue()).isEqualTo(142);
        assertThat(spiralSumMemory.findElement(-2, 0).getValue()).isEqualTo(133);
        assertThat(spiralSumMemory.findElement(-2, 1).getValue()).isEqualTo(122);
        assertThat(spiralSumMemory.findElement(-2, 2).getValue()).isEqualTo(59);
        assertThat(spiralSumMemory.findElement(-1, -2).getValue()).isEqualTo(304);
        assertThat(spiralSumMemory.findElement(-1, -1).getValue()).isEqualTo(5);
        assertThat(spiralSumMemory.findElement(-1, 0).getValue()).isEqualTo(4);
        assertThat(spiralSumMemory.findElement(-1, 1).getValue()).isEqualTo(2);
        assertThat(spiralSumMemory.findElement(-1, 2).getValue()).isEqualTo(57);
        assertThat(spiralSumMemory.findElement(0, -2).getValue()).isEqualTo(330);
        assertThat(spiralSumMemory.findElement(0, -1).getValue()).isEqualTo(10);
        assertThat(spiralSumMemory.findElement(0, 0).getValue()).isEqualTo(1);
        assertThat(spiralSumMemory.findElement(0, 1).getValue()).isEqualTo(1);
        assertThat(spiralSumMemory.findElement(0, 2).getValue()).isEqualTo(54);
        assertThat(spiralSumMemory.findElement(1, -2).getValue()).isEqualTo(351);
        assertThat(spiralSumMemory.findElement(1, -1).getValue()).isEqualTo(11);
        assertThat(spiralSumMemory.findElement(1, 0).getValue()).isEqualTo(23);
        assertThat(spiralSumMemory.findElement(1, 1).getValue()).isEqualTo(25);
        assertThat(spiralSumMemory.findElement(1, 2).getValue()).isEqualTo(26);
        assertThat(spiralSumMemory.findElement(2, -2).getValue()).isEqualTo(362);
        assertThat(spiralSumMemory.findElement(2, -1).getValue()).isEqualTo(747);
        assertThat(spiralSumMemory.findElement(2, 0).getValue()).isEqualTo(806);
    }

    @Test
    public void findElementBiggerThan() {
        SpiralSumMemory spiralSumMemory = new SpiralSumMemory(800);

        assertThat(spiralSumMemory.findElementWithValueBiggerThan(350)).isEqualTo(351);
        assertThat(spiralSumMemory.findElementWithValueBiggerThan(800)).isEqualTo(806);
        assertThat(spiralSumMemory.findElementWithValueBiggerThan(25)).isEqualTo(26);
    }
}