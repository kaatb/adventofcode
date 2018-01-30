package adventofcode.day11;

import org.junit.Test;

import java.util.List;

import static adventofcode.day11.HexAlignment.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HexPathParserTest {

    @Test
    public void parse() {
        List<HexAlignment> actual = new HexPathParser().parse("se,n,s,sw,nw,ne");

        assertThat(actual).containsExactly(SOUTH_EAST, NORTH, SOUTH, SOUTH_WEST, NORTH_WEST, NORTH_EAST);
    }
}