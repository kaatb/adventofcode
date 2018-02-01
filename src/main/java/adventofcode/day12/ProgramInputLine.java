package adventofcode.day12;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

class ProgramInputLine {

    private String line;

    public ProgramInputLine(String line) {
        this.line = line;
    }

    public Integer getId() {
        return Integer.parseInt(line.substring(0, line.indexOf("<->")).trim());
    }

    public List<Integer> getConnections() {
        return stream(line.substring(line.indexOf(">") + 1).split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
    }
}
