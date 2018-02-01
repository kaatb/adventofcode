package adventofcode.day12;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class ProgramResolver {

    private List<Program> programs;

    ProgramResolver(List<Program> programs) {
        this.programs = programs;
    }

    public List<Program> findProgramsConnectedTo(Integer id) {
        return programs.stream()
                .filter(program -> program.connectsTo(id))
                .collect(toList());
    }

    public Integer findNumberOfGroups() {
        List<Program> programsCopy = newArrayList(programs);
        Integer numberOfGroups = 0;
        while (programsCopy.size() > 0) {
            Program program = programsCopy.get(0);
            programsCopy.removeAll(findProgramsConnectedTo(program.getId()));
            numberOfGroups++;
        }
        return numberOfGroups;
    }
}
