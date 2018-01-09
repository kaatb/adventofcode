package adventofcode.day3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManhattanDistanceResolverTest {

    @Test
    public void resolve() {
        assertThat(new ManhattanDistanceResolver().resolve(17)).isEqualTo(4);
        assertThat(new ManhattanDistanceResolver().resolve(1)).isEqualTo(0);
        assertThat(new ManhattanDistanceResolver().resolve(12)).isEqualTo(3);
        assertThat(new ManhattanDistanceResolver().resolve(23)).isEqualTo(2);
        assertThat(new ManhattanDistanceResolver().resolve(1024)).isEqualTo(31);
    }
}