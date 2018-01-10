package adventofcode.day7;

import java.util.List;

import static java.util.stream.Collectors.toList;

class ProgramLinker {

    public void linkPrograms(List<ProgramInputLine> lines, List<Program> programList) {
        lines.stream()
                .filter(ProgramInputLine::hasSubprograms)
                .forEach(line -> {
                    Program baseProgram = findProgramByName(programList, line.getName());
                    List<Program> subPrograms = line.getSubprograms().stream()
                            .map(subprogram -> findProgramByName(programList, subprogram))
                            .collect(toList());
                    baseProgram.setPrograms(subPrograms);
                });
    }

    private Program findProgramByName(List<Program> programList, String name) {
        return programList.stream().filter(program -> program.getName().equals(name)).findFirst().get();
    }
}
