package adventofcode.day2;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class ChecksumLineTest {

    @Test
    public void getMaxMinChecksum() {
        assertThat(new ChecksumLine(Arrays.asList(1, 4, 2)).getMaxMinChecksum()).isEqualTo(3);
        assertThat(new ChecksumLine(newArrayList(5, 1, 9, 5)).getMaxMinChecksum()).isEqualTo(8);
        assertThat(new ChecksumLine(newArrayList(7, 5, 3)).getMaxMinChecksum()).isEqualTo(4);
        assertThat(new ChecksumLine(newArrayList(2, 4, 6, 8)).getMaxMinChecksum()).isEqualTo(6);
    }

    @Test
    public void getEvenlyDivisibleChecksum() {
        assertThat(new ChecksumLine(newArrayList(5, 9, 2, 8)).getEvenlyDivisibleChecksum()).isEqualTo(4);
        assertThat(new ChecksumLine(newArrayList(9, 4, 7, 3)).getEvenlyDivisibleChecksum()).isEqualTo(3);
        assertThat(new ChecksumLine(newArrayList(3, 8, 6, 5)).getEvenlyDivisibleChecksum()).isEqualTo(2);
    }
}