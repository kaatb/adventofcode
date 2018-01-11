package adventofcode.day7;

import java.util.List;

class Program {

    private final int weight;
    private final String name;
    private List<Program> programs;

    Program(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public boolean hasPrograms() {
        return programs != null && programs.size() > 0;
    }

    public boolean hasProgram(Program program) {
        return hasPrograms() && programs.contains(program);
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public boolean isBalanced() {
        return !hasPrograms() || programs.stream().map(Program::getBalancedWeight).distinct().count() == 1;
    }

    public int getBalancedWeight() {
        int balancedWeight = weight;
        if (hasPrograms()) {
            for (Program program : programs) {
                balancedWeight += program.getBalancedWeight();
            }
        }
        return balancedWeight;
    }

    public Program findUnbalancedProgram() {
        if (!isBalanced()) {
            Program unbalancedProgram = this;
            for (Program program : getPrograms()) {
                Program unbalancedSub = program.findUnbalancedProgram();
                if (unbalancedSub != null) {
                    unbalancedProgram = unbalancedSub;
                }
            }
            return unbalancedProgram;
        } else {
            return null;
        }
    }

}

