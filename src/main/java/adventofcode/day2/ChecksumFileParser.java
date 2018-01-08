package adventofcode.day2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class ChecksumFileParser {

    List<ChecksumLine> parse(List<String> lines) {
        return lines.stream()
                .map(line -> new ChecksumLine(Arrays.stream(line.split("\t"))
                        .map(Integer::parseInt)
                        .collect(toList())))
                .collect(toList());
    }
}
