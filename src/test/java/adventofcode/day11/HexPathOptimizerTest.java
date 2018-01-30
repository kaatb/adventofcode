package adventofcode.day11;

import org.junit.Test;

import static adventofcode.day11.HexAlignment.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class HexPathOptimizerTest {

    @Test
    public void getNumberOfStepsInOptimizedPath() {
        assertThat(new HexPathOptimizer().getNumberOfStepsInOptimizedPath(asList(NORTH_EAST, NORTH_EAST, NORTH_EAST))).isEqualTo(3);
        assertThat(new HexPathOptimizer().getNumberOfStepsInOptimizedPath(asList(NORTH_EAST, NORTH_EAST, SOUTH_WEST, SOUTH_WEST))).isEqualTo(0);
        assertThat(new HexPathOptimizer().getNumberOfStepsInOptimizedPath(asList(NORTH_EAST, NORTH_EAST, SOUTH, SOUTH))).isEqualTo(2);
        assertThat(new HexPathOptimizer().getNumberOfStepsInOptimizedPath(asList(SOUTH_EAST, SOUTH_WEST, SOUTH_EAST, SOUTH_WEST, SOUTH_WEST))).isEqualTo(3);
    }
}