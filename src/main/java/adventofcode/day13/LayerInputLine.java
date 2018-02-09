package adventofcode.day13;

import static java.lang.Long.parseLong;
import static org.apache.commons.lang3.StringUtils.split;

public class LayerInputLine {

    private final String input;
    private static final String SEPARATOR = ":";

    LayerInputLine(String input) {
        this.input = input;
    }

    Long getDepth() {
        return parseLong(split(input, SEPARATOR)[0].trim());
    }

    Long getRange() {
        return parseLong(split(input, SEPARATOR)[1].trim());
    }
}
