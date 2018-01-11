package adventofcode.day7;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramTest {

    private static final String NAME = "name";

    @Test
    public void isBalanced_TrueIfNoSubprograms() {
        assertThat(new Program(1, NAME).isBalanced()).isTrue();
    }

    @Test
    public void isBalanced_TrueWhenSubprogramsAreSameWeight() {
        Program subA = new Program(1, NAME);
        Program subB = new Program(1, NAME);
        Program subC = new Program(1, NAME);
        Program programWithSubs = new Program(5, NAME);
        programWithSubs.setPrograms(Arrays.asList(subA, subB, subC));
        assertThat(programWithSubs.isBalanced()).isTrue();
    }

    @Test
    public void isBalanced_FalseWhenSubprogramsAreDifferentWeight() {
        Program subA = new Program(1, NAME);
        Program subB = new Program(1, NAME);
        Program subC = new Program(2, NAME);
        Program programWithSubs = new Program(5, NAME);
        programWithSubs.setPrograms(Arrays.asList(subA, subB, subC));
        assertThat(programWithSubs.isBalanced()).isFalse();
    }

    @Test
    public void isBalanced_TrueWhenRecursiveSubprogramsAreSameWeight() {
        Program subsubA = new Program(1, NAME);
        Program subsubB = new Program(1, NAME);
        Program subsubC = new Program(1, NAME);
        Program programWithSubs = new Program(5, NAME);
        programWithSubs.setPrograms(Arrays.asList(subsubA, subsubB, subsubC));

        Program otherProgram = new Program(8, NAME);

        Program programToTest = new Program(2, NAME);
        programToTest.setPrograms(Arrays.asList(programWithSubs, otherProgram));

        assertThat(programToTest.isBalanced()).isTrue();
    }

    @Test
    public void isBalanced_FalseWhenRecursiveSubprogramsAreDifferentWeight() {
        Program subsubA = new Program(1, "subsubA");
        Program subsubB = new Program(1, "subsubB");
        Program subsubC = new Program(1, "subsubC");
        Program programWithSubs = new Program(4, "programWithSubs");
        programWithSubs.setPrograms(Arrays.asList(subsubA, subsubB, subsubC));

        Program otherProgram = new Program(8, "otherProgram");

        Program programToTest = new Program(2, "programToTest");
        programToTest.setPrograms(Arrays.asList(programWithSubs, otherProgram));

        assertThat(programToTest.isBalanced()).isFalse();
    }

    @Test
    public void findUnbalancedProgram_NullWhenSubprogramsAreSameWeight() {
        Program subA = new Program(1, NAME);
        Program subB = new Program(1, NAME);
        Program subC = new Program(1, NAME);
        Program programWithSubs = new Program(5, NAME);
        programWithSubs.setPrograms(Arrays.asList(subA, subB, subC));
        assertThat(programWithSubs.findUnbalancedProgram()).isNull();
    }

    @Test
    public void findUnbalancedProgram_subProgramWhenSubprogramsAreDifferentWeight() {
        Program subA = new Program(1, NAME);
        Program subB = new Program(1, NAME);
        Program subC = new Program(2, NAME);
        Program programWithSubs = new Program(5, NAME);
        programWithSubs.setPrograms(Arrays.asList(subA, subB, subC));
        assertThat(programWithSubs.findUnbalancedProgram()).isEqualTo(programWithSubs);
    }

    @Test
    public void findUnbalanced_NullWhenRecursiveSubprogramsAreSameWeight() {
        Program subsubA = new Program(1, NAME);
        Program subsubB = new Program(1, NAME);
        Program subsubC = new Program(1, NAME);
        Program programWithSubs = new Program(5, NAME);
        programWithSubs.setPrograms(Arrays.asList(subsubA, subsubB, subsubC));

        Program otherProgram = new Program(8, NAME);

        Program programToTest = new Program(2, NAME);
        programToTest.setPrograms(Arrays.asList(programWithSubs, otherProgram));

        assertThat(programToTest.findUnbalancedProgram()).isNull();
    }

    @Test
    public void findUnbalancedProgram_SubprogramWhenRecursiveSubprogramsAreDifferentWeight() {
        Program subsubA = new Program(1, "subsubA");
        Program subsubB = new Program(2, "subsubB");
        Program subsubC = new Program(1, "subsubC");
        Program programWithSubs = new Program(3, "programWithSubs");
        programWithSubs.setPrograms(Arrays.asList(subsubA, subsubB, subsubC));

        Program otherProgram = new Program(8, "otherProgram");

        Program programToTest = new Program(2, "programToTest");
        programToTest.setPrograms(Arrays.asList(programWithSubs, otherProgram));

        assertThat(programToTest.findUnbalancedProgram()).isEqualTo(programWithSubs);
    }

}