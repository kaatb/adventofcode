package adventofcode.day8;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InstructionConditionEvaluatorTest {


    private InstructionConditionEvaluator evaluator = new InstructionConditionEvaluator();

    @Test
    public void isConditionMet_Equals_True() {
        assertThat(evaluator.isConditionMet(createRegister(5), "==", 5)).isTrue();
    }

    @Test
    public void isConditionMet_Equals_False() {
        assertThat(evaluator.isConditionMet(createRegister(5), "==", 4)).isFalse();
    }

    @Test
    public void isConditionMet_NotEquals_True() {
        assertThat(evaluator.isConditionMet(createRegister(5), "!=", 4)).isTrue();
    }

    @Test
    public void isConditionMet_NotEquals_False() {
        assertThat(evaluator.isConditionMet(createRegister(5), "!=", 5)).isFalse();
    }

    @Test
    public void isConditionMet_GreaterThan_True() {
        assertThat(evaluator.isConditionMet(createRegister(5), ">", 4)).isTrue();
    }

    @Test
    public void isConditionMet_GreaterThan_False() {
        assertThat(evaluator.isConditionMet(createRegister(5), ">", 5)).isFalse();
    }

    @Test
    public void isConditionMet_GreaterThanOrEqual_TrueIfEqual() {
        assertThat(evaluator.isConditionMet(createRegister(5), ">=", 5)).isTrue();
    }

    @Test
    public void isConditionMet_GreaterThanOrEqual_TrueIfGreaterThan() {
        assertThat(evaluator.isConditionMet(createRegister(5), ">=", 4)).isTrue();
    }

    @Test
    public void isConditionMet_GreaterThanOrEqual_False() {
        assertThat(evaluator.isConditionMet(createRegister(5), ">=", 6)).isFalse();
    }

    @Test
    public void isConditionMet_SmallerThan_True() {
        assertThat(evaluator.isConditionMet(createRegister(5), "<", 6)).isTrue();
    }

    @Test
    public void isConditionMet_SmallerThan_False() {
        assertThat(evaluator.isConditionMet(createRegister(5), "<", 5)).isFalse();
    }

    @Test
    public void isConditionMet_SmallerThanOrEqual_TrueIfSmallerThan() {
        assertThat(evaluator.isConditionMet(createRegister(5), "<=", 6)).isTrue();
    }

    @Test
    public void isConditionMet_SmallerThanOrEqual_TrueIfEqual() {
        assertThat(evaluator.isConditionMet(createRegister(5), "<=", 5)).isTrue();
    }

    @Test
    public void isConditionMet_SmallerThanOrEqual_False() {
        assertThat(evaluator.isConditionMet(createRegister(5), "<=", 4)).isFalse();
    }

    private Register createRegister(int value) {
        Register register = new Register("aName");
        register.increase(value);
        return register;
    }
}