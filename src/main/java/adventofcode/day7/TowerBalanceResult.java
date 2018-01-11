package adventofcode.day7;

class TowerBalanceResult {

    private final Program program;
    private final int offBalance;

    TowerBalanceResult(Program program, int offBalance) {
        this.program = program;
        this.offBalance = offBalance;
    }

    public int getNewWeight() {
        return program.getWeight() + offBalance;
    }

    public String getProgramName() {
        return program.getName();
    }

    @Override
    public String toString() {
        return getProgramName() + " - " + getNewWeight();
    }
}
