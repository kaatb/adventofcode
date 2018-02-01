package adventofcode.day12;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class ProgramInputParser {

    public List<Program> parse(List<ProgramInputLine> programInputLines) {
        List<Program> programs = createPrograms(programInputLines);
        return connectPrograms(programInputLines, programs);
    }

    List<Program> connectPrograms(List<ProgramInputLine> programInputLines, List<Program> programs) {
        programInputLines
                .forEach(inputLine -> {
                    Program base = findProgramWithId(programs, inputLine.getId());
                    inputLine.getConnections().stream()
                            .map(connection -> findProgramWithId(programs, connection))
                            .forEach(base::addConnections);
                });
        return programs;
    }

    List<Program> createPrograms(List<ProgramInputLine> programInputLines) {
        List<Program> programs = newArrayList();
        programInputLines
                .forEach(inputLine -> programs.add(new Program(inputLine.getId())));
        return programs;
    }

    private Program findProgramWithId(List<Program> programs, Integer id) {
        return programs.stream().filter(program -> program.getId().equals(id)).findFirst().get();
    }
}
