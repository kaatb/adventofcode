package adventofcode.day12;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ProgramInputParserTest {

    private static final ProgramInputLine INPUT_0 = new ProgramInputLine("0 <-> 2");
    private static final ProgramInputLine INPUT_1 = new ProgramInputLine("1 <-> 1");
    private static final ProgramInputLine INPUT_2 = new ProgramInputLine("2 <-> 0, 3, 4");
    private static final ProgramInputLine INPUT_3 = new ProgramInputLine("3 <-> 2, 4");
    private static final ProgramInputLine INPUT_4 = new ProgramInputLine("4 <-> 2, 3, 6");
    private static final ProgramInputLine INPUT_5 = new ProgramInputLine("5 <-> 6");
    private static final ProgramInputLine INPUT_6 = new ProgramInputLine("6 <-> 4, 5");

    private Program program_0 = new Program(0);
    private Program program_1 = new Program(1);
    private Program program_2 = new Program(2);
    private Program program_3 = new Program(3);
    private Program program_4 = new Program(4);
    private Program program_5 = new Program(5);
    private Program program_6 = new Program(6);

    @Test
    public void parse() {
        List<Program> actual = new ProgramInputParser().createPrograms(asList(INPUT_0, INPUT_1, INPUT_2, INPUT_3, INPUT_4, INPUT_5, INPUT_6));

        assertThat(actual).containsExactly(program_0, program_1, program_2, program_3, program_4, program_5, program_6);
    }

    @Test
    public void connectPrograms_single() {
        List<Program> actual = new ProgramInputParser().connectPrograms(asList(INPUT_0), Arrays.asList(program_0, program_1, program_2, program_3, program_4, program_5, program_6));

        assertThat(actual.get(0).getConnections()).containsExactly(program_2);
    }

    @Test
    public void connectPrograms_multiple() {
        List<Program> actual = new ProgramInputParser().connectPrograms(asList(INPUT_4), Arrays.asList(program_0, program_1, program_2, program_3, program_4, program_5, program_6));

        assertThat(actual.get(4).getConnections()).containsExactly(program_2, program_3, program_6);
    }

    @Test
    public void connectPrograms_itself() {
        List<Program> actual = new ProgramInputParser().connectPrograms(asList(INPUT_1), Arrays.asList(program_0, program_1, program_2, program_3, program_4, program_5, program_6));

        assertThat(actual.get(1).getConnections()).containsExactly(program_1);
    }
}