package adventofcode.day7;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgramInputLineTest {

    private static final int WEIGHT = 57;
    private static final int ANOTHER_WEIGHT = 72;
    private static final String NAME = "ktlj";
    private static final String ANOTHER_NAME = "fwft";
    private static final String LINE_WITHOUT_SUBPROGRAMS = NAME + " (" + WEIGHT + ")";
    private static final String LINE_WITH_SUBPROGRAMS = ANOTHER_NAME + " (" + ANOTHER_WEIGHT + ") -> ktlj, cntj, xhth";

    @Test
    public void getWeight() {
        assertThat(new ProgramInputLine(LINE_WITHOUT_SUBPROGRAMS).getWeight()).isEqualTo(WEIGHT);
        assertThat(new ProgramInputLine(LINE_WITH_SUBPROGRAMS).getWeight()).isEqualTo(ANOTHER_WEIGHT);
    }

    @Test
    public void getName() {
        assertThat(new ProgramInputLine(LINE_WITHOUT_SUBPROGRAMS).getName()).isEqualTo(NAME);
        assertThat(new ProgramInputLine(LINE_WITH_SUBPROGRAMS).getName()).isEqualTo(ANOTHER_NAME);
    }

    @Test
    public void hasSubprograms() {
        assertThat(new ProgramInputLine(LINE_WITHOUT_SUBPROGRAMS).hasSubprograms()).isFalse();
        assertThat(new ProgramInputLine(LINE_WITH_SUBPROGRAMS).hasSubprograms()).isTrue();
    }

    @Test
    public void getSubprograms() {
        assertThat(new ProgramInputLine(LINE_WITHOUT_SUBPROGRAMS).getSubprograms()).isEmpty();
        assertThat(new ProgramInputLine(LINE_WITH_SUBPROGRAMS).getSubprograms()).containsExactly("ktlj", "cntj", "xhth");
    }
}