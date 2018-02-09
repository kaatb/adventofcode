package adventofcode.day14;

import org.apache.commons.lang3.StringUtils;

class HexadecimalToBinaryConverter {

    public String convert(String input) {
        return input.chars()
                .mapToObj(c -> toHexadecimal((char) c))
                .map(Integer::toBinaryString)
                .map(bits -> StringUtils.leftPad(bits, 4, "0"))
                .reduce((a, b) -> a + b)
                .get();
    }

    private int toHexadecimal(char c) {
        return Integer.parseInt(c + "", 16);
    }
}
