package adventofcode.day10;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class HashCalculatorIntegrationTest {

    @Test
    public void knotHash() {
        assertThat(new HashCalculator().knotHash(createIntegerListOfLength(256), stringToAsciiList(""), 64))
                .isEqualTo("a2582a3a0e66e6e86e3812dcb672a272");
        assertThat(new HashCalculator().knotHash(createIntegerListOfLength(256), stringToAsciiList("AoC 2017"), 64))
                .isEqualTo("33efeb34ea91902bb2f59c9920caa6cd");
        assertThat(new HashCalculator().knotHash(createIntegerListOfLength(256), stringToAsciiList("1,2,3"), 64))
                .isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d");
        assertThat(new HashCalculator().knotHash(createIntegerListOfLength(256), stringToAsciiList("1,2,4"), 64))
                .isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e");
    }

    private List<Integer> stringToAsciiList(String input) {
        List<Integer> integers = input.chars()
                .map(c -> (int) c)
                .mapToObj(i -> Integer.valueOf(i))
                .collect(Collectors.toList());
        integers.addAll(Arrays.asList(17, 31, 73, 47, 23));
        return integers;
    }

    private List<Integer> createIntegerListOfLength(int length) {
        List<Integer> list = newArrayList();
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        return list;
    }
}
