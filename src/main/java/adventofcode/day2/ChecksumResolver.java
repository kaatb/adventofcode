package adventofcode.day2;

import java.util.List;

class ChecksumResolver {

    int resolveMaxMin(List<String> lines) {
        List<ChecksumLine> checksumLines = new ChecksumFileParser().parse(lines);
        return checksumLines.stream()
                .mapToInt(ChecksumLine::getMaxMinChecksum)
                .reduce(0, (a, b) -> a + b);
    }

    int resolveEvenlyDivisble(List<String> lines) {
        List<ChecksumLine> checksumLines = new ChecksumFileParser().parse(lines);
        return checksumLines.stream()
                .mapToInt(ChecksumLine::getEvenlyDivisibleChecksum)
                .reduce(0, (a, b) -> a + b);
    }
}
