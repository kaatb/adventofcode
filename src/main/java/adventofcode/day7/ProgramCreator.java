package adventofcode.day7;

import java.util.List;

import static java.util.stream.Collectors.toList;

class ProgramCreator {

    List<Program> createAllPrograms(List<ProgramInputLine> lines) {
        return lines.stream()
                .map(programInputLine -> new Program(programInputLine.getWeight(), programInputLine.getName()))
                .collect(toList());
    }


}
