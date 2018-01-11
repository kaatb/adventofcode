package adventofcode.day8;

import org.junit.Test;

import static adventofcode.day8.Action.DECREASE;
import static adventofcode.day8.Action.INCREASE;
import static org.assertj.core.api.Assertions.assertThat;

public class InstructionLineTest {

    private static final InstructionLine INSTRUCTION_LINE = new InstructionLine("ic dec 392 if ucy != -695");
    private static final InstructionLine INSTRUCTION_LINE_INCREASE = new InstructionLine("ic inc 392 if ucy != -695");

    @Test
    public void getRegisterForCondition() {
        assertThat(INSTRUCTION_LINE.getRegisterForCondition()).isEqualTo("ucy");
    }

    @Test
    public void getValueForCondition() {
        assertThat(INSTRUCTION_LINE.getValueForCondition()).isEqualTo(-695);
    }

    @Test
    public void getConditionalSign() {
        assertThat(INSTRUCTION_LINE.getConditionalSign()).isEqualTo("!=");
    }

    @Test
    public void getRegisterForAction() {
        assertThat(INSTRUCTION_LINE.getRegisterForAction()).isEqualTo("ic");
    }

    @Test
    public void getValueForAction() {
        assertThat(INSTRUCTION_LINE.getValueForAction()).isEqualTo(392);
    }

    @Test
    public void getAction_decrease() {
        assertThat(INSTRUCTION_LINE.getAction()).isEqualTo(DECREASE);
    }

    @Test
    public void getAction_increase() {
        assertThat(INSTRUCTION_LINE_INCREASE.getAction()).isEqualTo(INCREASE);
    }
}