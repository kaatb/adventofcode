package adventofcode.day14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HexadecimalToBinaryConverterTest {

    private final HexadecimalToBinaryConverter converter = new HexadecimalToBinaryConverter();

    @Test
    public void convert() {
        assertThat(converter.convert("F")).isEqualTo("1111");
        assertThat(converter.convert("0123456789ABCDEF")).isEqualTo("0000000100100011010001010110011110001001101010111100110111101111");
    }
}