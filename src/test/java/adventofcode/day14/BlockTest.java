package adventofcode.day14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlockTest {

    @Test
    public void isNeighbour_noDiagonal() {
        Block leftUp = new Block(0, 0, false);
        Block left = new Block(0, 1, true);
        Block leftDown = new Block(0, 2, true);
        Block up = new Block(1, 0, true);
        Block center = new Block(1, 1, false);
        Block down = new Block(1, 2, false);
        Block rightUp = new Block(2, 0, true);
        Block right = new Block(2, 1, true);
        Block rightDown = new Block(2, 2, true);

        assertThat(leftUp.isNeighbour(center)).isFalse();
        assertThat(left.isNeighbour(center)).isTrue();
        assertThat(leftDown.isNeighbour(center)).isFalse();
        assertThat(up.isNeighbour(center)).isTrue();
        assertThat(center.isNeighbour(center)).isFalse();
        assertThat(down.isNeighbour(center)).isTrue();
        assertThat(rightUp.isNeighbour(center)).isFalse();
        assertThat(right.isNeighbour(center)).isTrue();
        assertThat(rightDown.isNeighbour(center)).isFalse();
    }
}