package adventofcode.day10;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SublistReverserTest {

    @Test
    public void reverse_case1() {
        List<Integer> actual = new SublistReverser().reverse(Arrays.asList(0, 1, 2, 3, 4), 3, 0);
        assertThat(actual).containsExactly(2, 1, 0, 3, 4);
    }

    @Test
    public void reverse_case2() {
        List<Integer> actual = new SublistReverser().reverse(Arrays.asList(2, 1, 0, 3, 4), 4, 3);
        assertThat(actual).containsExactly(4, 3, 0, 1, 2);
    }

    @Test
    public void reverse_case3() {
        List<Integer> actual = new SublistReverser().reverse(Arrays.asList(4, 3, 0, 1, 2), 1, 3);
        assertThat(actual).containsExactly(4, 3, 0, 1, 2);
    }

    @Test
    public void reverse_case4() {
        List<Integer> actual = new SublistReverser().reverse(Arrays.asList(4, 3, 0, 1, 2), 5, 1);
        assertThat(actual).containsExactly(3, 4, 2, 1, 0);
    }
}