package adventofcode.day7;

import java.util.function.Predicate;

class TowerBalancer {

    TowerBalanceResult fixTowerBalance(Program baseProgram) {
        Program unbalancedProgram = baseProgram.findUnbalancedProgram();

        Program programWithWrongWeight = unbalancedProgram.getPrograms().stream()
                .filter(filterProgramWithUniqueBalancedWeight(unbalancedProgram))
                .findFirst().get();
        int goodBalance = unbalancedProgram.getPrograms().stream()
                .filter(filterProgramsWithSameBalancedWeight(unbalancedProgram))
                .findFirst().get().getBalancedWeight();
        return new TowerBalanceResult(programWithWrongWeight, goodBalance - programWithWrongWeight.getBalancedWeight());
    }

    private Predicate<Program> filterProgramsWithSameBalancedWeight(Program unbalancedProgram) {
        return program -> unbalancedProgram.getPrograms().stream()
                .filter(subprogram -> subprogram.getBalancedWeight() == program.getBalancedWeight())
                .count() > 1;
    }

    private Predicate<Program> filterProgramWithUniqueBalancedWeight(Program unbalancedProgram) {
        return program -> unbalancedProgram.getPrograms().stream()
                .filter(subprogram -> subprogram.getBalancedWeight() == program.getBalancedWeight())
                .count() == 1;
    }
}
