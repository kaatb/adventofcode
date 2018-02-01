package adventofcode.day12;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramInputLineTest {

    @Test
    public void getId() {
        assertThat(new ProgramInputLine("0 <-> 2").getId()).isEqualTo(0);
        assertThat(new ProgramInputLine("1 <-> 1").getId()).isEqualTo(1);
        assertThat(new ProgramInputLine("4 <-> 2, 3, 6").getId()).isEqualTo(4);
    }

    @Test
    public void getConnections() {
        assertThat(new ProgramInputLine("0 <-> 2").getConnections()).containsExactly(2);
        assertThat(new ProgramInputLine("1 <-> 1").getConnections()).containsExactly(1);
        assertThat(new ProgramInputLine("4 <-> 2, 3, 6").getConnections()).containsExactly(2, 3, 6);
    }

}