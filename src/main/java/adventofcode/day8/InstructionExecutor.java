package adventofcode.day8;

import java.util.List;
import java.util.Map;

import static adventofcode.day8.Action.INCREASE;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Comparator.comparing;

class InstructionExecutor {

    private InstructionConditionEvaluator instructionConditionEvaluator = new InstructionConditionEvaluator();

    private Map<String, Register> registers = newHashMap();

    public void execute(List<InstructionLine> instructionLines) {
        instructionLines.stream()
                .forEach(instruction -> {
                            if (isConditionMet(instruction)) {
                                doInstruction(instruction);
                            }
                        }
                );
    }

    private void doInstruction(InstructionLine instruction) {
        if (INCREASE.equals(instruction.getAction())) {
            getRegisterForName(instruction.getRegisterForAction()).increase(instruction.getValueForAction());
        } else {
            getRegisterForName(instruction.getRegisterForAction()).decrease(instruction.getValueForAction());
        }
    }

    private boolean isConditionMet(InstructionLine instruction) {
        return instructionConditionEvaluator.isConditionMet(
                getRegisterForName(instruction.getRegisterForCondition()),
                instruction.getConditionalSign(),
                instruction.getValueForCondition()
        );
    }

    private Register getRegisterForName(String registerName) {
        if (!registers.containsKey(registerName)) {
            addRegister(registerName);
        }
        return registers.get(registerName);
    }

    private void addRegister(String registerToAdd) {
        registers.put(registerToAdd, new Register(registerToAdd));
    }

    public Register findRegisterWithLargestValue() {
        return registers.values().stream().max(comparing(Register::getValue)).get();
    }

    public Register findRegisterWithLargestHistoricalValue() {
        return registers.values().stream().max(comparing(Register::getMaxValue)).get();
    }
}
