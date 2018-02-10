package adventofcode.day16;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DanceGroupTest {

    private List<Program> danceGroupStartPositions;
    private Program a = new Program("a", 0);
    private Program b = new Program("b", 1);
    private Program c = new Program("c", 2);
    private Program d = new Program("d", 3);
    private Program e = new Program("e", 4);

    @Before
    public void setUp() throws Exception {
        danceGroupStartPositions = asList(a, b, c, d, e);
    }

    @Test
    public void doDance_spin1() {
        DanceGroup danceGroup = new DanceGroup(danceGroupStartPositions);

        danceGroup.doDance(asList(new Spin(1)));

        assertThat(danceGroup.getPrograms()).containsExactly(e, a, b, c, d);
    }

    @Test
    public void doDance_spin3() {
        DanceGroup danceGroup = new DanceGroup(danceGroupStartPositions);

        danceGroup.doDance(asList(new Spin(3)));

        assertThat(danceGroup.getPrograms()).containsExactly(c, d, e, a, b);
    }

    @Test
    public void doDance_exchange() {
        DanceGroup danceGroup = new DanceGroup(danceGroupStartPositions);

        danceGroup.doDance(asList(new Exchange(3, 4)));

        assertThat(danceGroup.getPrograms()).containsExactly(a, b, c, e, d);
    }

    @Test
    public void doDance_partner() {
        DanceGroup danceGroup = new DanceGroup(danceGroupStartPositions);

        danceGroup.doDance(asList(new Partner("b", "d")));

        assertThat(danceGroup.getPrograms()).containsExactly(a, d, c, b, e);
    }
}