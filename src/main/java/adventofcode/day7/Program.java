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

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public boolean hasPrograms() {
        return programs != null && programs.size() > 0;
    }

    public boolean hasProgram(Program program) {
        return hasPrograms() && programs.contains(program);
    }

}

