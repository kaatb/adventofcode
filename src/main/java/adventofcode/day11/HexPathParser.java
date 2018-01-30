package adventofcode.day11;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class HexPathParser {

    public List<HexAlignment> parse(String input) {
        return Arrays.stream(input.split(","))
                .map(HexAlignment::forDirection)
                .collect(toList());
    }
}
