package adventofcode.day8;


class InstructionLine {

    private static final String CONDITION_KEYWORD = "if";
    public static final String INSTRUCTION_SPACE = " ";

    private final String instruction;

    InstructionLine(String instruction) {
        this.instruction = instruction;
    }

    public String getRegisterForCondition() {
        return getConditionalStatement().split(INSTRUCTION_SPACE)[0];
    }

    public String getConditionalSign() {
        return getConditionalStatement().split(INSTRUCTION_SPACE)[1];
    }

    public int getValueForCondition() {
        return Integer.parseInt(getConditionalStatement().split(INSTRUCTION_SPACE)[2]);
    }

    private String getConditionalStatement() {
        return instruction.split(CONDITION_KEYWORD)[1].trim();
    }

    private String getActionStatement() {
        return instruction.split(CONDITION_KEYWORD)[0].trim();
    }

    public String getRegisterForAction() {
        return getActionStatement().split(INSTRUCTION_SPACE)[0];
    }

    public Action getAction() {
        return getActionStatement().split(INSTRUCTION_SPACE)[1].equals("inc") ? Action.INCREASE : Action.DECREASE;
    }

    public int getValueForAction() {
        return Integer.parseInt(getActionStatement().split(INSTRUCTION_SPACE)[2]);
    }
}
