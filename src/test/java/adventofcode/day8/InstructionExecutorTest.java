package adventofcode.day8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.unitils.util.ReflectionUtils;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class InstructionExecutorTest {

    @Mock
    private InstructionConditionEvaluator instructionConditionEvaluator;

    @InjectMocks
    private InstructionExecutor executor;
    private Register registerA = new Register("a");

    @Test
    public void execute_CallsConditionEvaluatorForEachInstructionLine() {
        executor.execute(Arrays.asList(
                new InstructionLine("a inc 1 if a == 0"),
                new InstructionLine("b inc 1 if a == 2"),
                new InstructionLine("b dec 1 if a > 0")));

        verify(instructionConditionEvaluator).isConditionMet(eq(registerA), eq("=="), eq(0));
        verify(instructionConditionEvaluator).isConditionMet(eq(registerA), eq("=="), eq(2));
        verify(instructionConditionEvaluator).isConditionMet(eq(registerA), eq(">"), eq(0));
    }

    @Test
    public void execute_CallsInstructionIfConditionMet() throws Exception {
        when(instructionConditionEvaluator.isConditionMet(eq(registerA), eq("=="), eq(0))).thenReturn(true);
        when(instructionConditionEvaluator.isConditionMet(eq(registerA), eq("=="), eq(2))).thenReturn(false);
        when(instructionConditionEvaluator.isConditionMet(eq(registerA), eq(">"), eq(0))).thenReturn(true);

        executor.execute(Arrays.asList(
                new InstructionLine("a inc 1 if a == 0"),
                new InstructionLine("b inc 1 if a == 2"),
                new InstructionLine("b dec 1 if a > 0")));

        assertThat(getRegisters().get("a").getValue()).isEqualTo(1);
        assertThat(getRegisters().get("b").getValue()).isEqualTo(-1);
    }

    private HashMap<String, Register> getRegisters() throws NoSuchFieldException {
        return ReflectionUtils.getFieldValue(executor, InstructionExecutor.class.getDeclaredField("registers"));
    }
}