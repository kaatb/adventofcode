package adventofcode.day16;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class DanceGroup {

    private List<Program> programs = newArrayList();

    DanceGroup(List<Program> programs) {
        this.programs = programs;
    }

    void doDance(List<DanceMove> danceMoves) {
        danceMoves.forEach(dancemove -> {
                    dancemove.reset();
                    programs.forEach(program -> program.doMove(dancemove, programs));
                }
        );
    }

    public List<Program> getPrograms() {
        return programs.stream().sorted(Comparator.comparingInt(Program::getPlace)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        getPrograms().stream().forEach(p -> stringBuilder.append(p));
        return stringBuilder.toString();
    }
}
