package adventofcode.day2;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class ChecksumLineTest {

    @Test
    public void getChecksum() {
        assertThat(new ChecksumLine(Arrays.asList(1, 4, 2)).getChecksum()).isEqualTo(3);
        assertThat(new ChecksumLine(newArrayList(5, 1, 9, 5)).getChecksum()).isEqualTo(8);
        assertThat(new ChecksumLine(newArrayList(7, 5, 3)).getChecksum()).isEqualTo(4);
        assertThat(new ChecksumLine(newArrayList(2, 4, 6, 8)).getChecksum()).isEqualTo(6);
    }
}