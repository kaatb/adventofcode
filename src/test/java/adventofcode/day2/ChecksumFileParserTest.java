package adventofcode.day2;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;

public class ChecksumFileParserTest {

    @Test
    public void parse() throws Exception {
        ReflectionAssert.assertLenientEquals(Arrays.asList(
                new ChecksumLine(newArrayList(5, 1, 9, 5)),
                new ChecksumLine(newArrayList(7, 5, 3)),
                new ChecksumLine(newArrayList(2, 4, 6, 8))
                ),
                new ChecksumFileParser().parse(newArrayList("5\t1\t9\t5", "7\t5\t3\t", "2\t4\t6\t8")));
    }
}