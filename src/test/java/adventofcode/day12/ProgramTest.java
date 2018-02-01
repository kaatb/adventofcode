package adventofcode.day12;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramTest {

    private Program program_0;
    private Program program_1;
    private Program program_2;
    private Program program_3;
    private Program program_4;
    private Program program_5;
    private Program program_6;

    @Before
    public void setup() {
        program_0 = new Program(0);
        program_1 = new Program(1);
        program_2 = new Program(2);
        program_3 = new Program(3);
        program_4 = new Program(4);
        program_5 = new Program(5);
        program_6 = new Program(6);

        program_0.addConnections(program_2);
        program_1.addConnections(program_1);
        program_2.addConnections(program_0);
        program_2.addConnections(program_3);
        program_2.addConnections(program_4);
        program_3.addConnections(program_2);
        program_3.addConnections(program_4);
        program_4.addConnections(program_2);
        program_4.addConnections(program_3);
        program_4.addConnections(program_6);
        program_5.addConnections(program_6);
        program_6.addConnections(program_4);
        program_6.addConnections(program_5);
    }

    @Test
    public void connectsTo() {
        assertThat(program_0.connectsTo(0)).isTrue();
        assertThat(program_1.connectsTo(0)).isFalse();
        assertThat(program_2.connectsTo(0)).isTrue();
        assertThat(program_3.connectsTo(0)).isTrue();
        assertThat(program_4.connectsTo(0)).isTrue();
        assertThat(program_5.connectsTo(0)).isTrue();
        assertThat(program_6.connectsTo(0)).isTrue();
    }

    @Test
    public void connectsTo_itself() {
        assertThat(program_1.connectsTo(1)).isTrue();
        assertThat(program_6.connectsTo(1)).isFalse();
    }
}
