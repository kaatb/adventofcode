package adventofcode.day8;

class InstructionConditionEvaluator {

    public boolean isConditionMet(Register register, String conditionalSign, int valueForCondition) {
        switch (conditionalSign) {
            case "==":
                return register.getValue() == valueForCondition;
            case "!=":
                return register.getValue() != valueForCondition;
            case ">":
                return register.getValue() > valueForCondition;
            case ">=":
                return register.getValue() >= valueForCondition;
            case "<":
                return register.getValue() < valueForCondition;
            case "<=":
                return register.getValue() <= valueForCondition;
            default:
                throw new UnsupportedOperationException("ConditionalSign not configured: " + conditionalSign);
        }
    }
}
