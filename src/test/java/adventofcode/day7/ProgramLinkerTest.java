package adventofcode.day7;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramLinkerTest {

    private static final ProgramInputLine A_INPUT_NO_SUBPROGRAMS = new ProgramInputLine("a (1)");
    private static final Program A_PROGRAM = new Program(1, "a");
    private static final ProgramInputLine B_INPUT_NO_SUBPROGRAMS = new ProgramInputLine("b (2)");
    private static final Program B_PROGRAM = new Program(2, "b");
    private static final ProgramInputLine C_INPUT_NO_SUBPROGRAMS = new ProgramInputLine("c (2) -> a");
    private static final Program C_PROGRAM = new Program(2, "c");

    private ProgramLinker programLinker = new ProgramLinker();

    @Test
    public void linkPrograms_NoSubprogramsDoesNothing() {
        programLinker.linkPrograms(Arrays.asList(A_INPUT_NO_SUBPROGRAMS, B_INPUT_NO_SUBPROGRAMS), Arrays.asList(A_PROGRAM, B_PROGRAM));

        assertThat(A_PROGRAM.hasPrograms()).isFalse();
        assertThat(B_PROGRAM.hasPrograms()).isFalse();
    }

    @Test
    public void linkPrograms_SubprogramsLinksPrograms() {
        programLinker.linkPrograms(Arrays.asList(A_INPUT_NO_SUBPROGRAMS, C_INPUT_NO_SUBPROGRAMS), Arrays.asList(A_PROGRAM, C_PROGRAM));

        assertThat(A_PROGRAM.hasPrograms()).isFalse();
        assertThat(C_PROGRAM.hasProgram(A_PROGRAM)).isTrue();
    }
}