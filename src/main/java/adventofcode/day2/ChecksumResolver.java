package adventofcode.day2;

import java.util.List;

class ChecksumResolver {

    int resolve(List<String> lines) {
        List<ChecksumLine> checksumLines = new ChecksumFileParser().parse(lines);
        return checksumLines.stream()
                .mapToInt(ChecksumLine::getChecksum)
                .reduce(0, (a, b) -> a + b);
    }
}
