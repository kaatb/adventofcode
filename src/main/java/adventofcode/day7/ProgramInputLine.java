package adventofcode.day7;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

class ProgramInputLine {

    private final String line;

    ProgramInputLine(String line) {
        this.line = line;
    }

    public int getWeight() {
        return Integer.parseInt(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
    }

    public String getName() {
        return line.substring(0, line.indexOf(" "));
    }

    public boolean hasSubprograms() {
        return line.contains("->");
    }

    public List<String> getSubprograms() {
        return hasSubprograms() ? stream(line.substring(line.indexOf(">") + 1).split(","))
                .map(String::trim).collect(toList())
                : Collections.emptyList();
    }
}
