package adventofcode.day10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HashCalculatorTest {

    @Mock
    private SublistReverser sublistReverser;

    @InjectMocks
    private HashCalculator hashCalculator;

    @Test
    public void knotHash() {
        when(sublistReverser.reverse(asList(0, 1, 2, 3, 4), 3, 0)).thenReturn(asList(2, 1, 0, 3, 4));
        when(sublistReverser.reverse(asList(2, 1, 0, 3, 4), 4, 3)).thenReturn(asList(4, 3, 0, 1, 2));
        when(sublistReverser.reverse(asList(4, 3, 0, 1, 2), 1, 3)).thenReturn(asList(4, 3, 0, 1, 2));
        when(sublistReverser.reverse(asList(4, 3, 0, 1, 2), 5, 1)).thenReturn(asList(3, 4, 2, 1, 0));

        List<Integer> actual = hashCalculator.sparseHash(asList(0, 1, 2, 3, 4), asList(3, 4, 1, 5));

        assertThat(actual).containsExactly(3, 4, 2, 1, 0);
    }

    @Test
    public void denseHash() {
        List<Integer> actual = hashCalculator.calculateDenseHash(Arrays.asList(65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22));
        assertThat(actual).containsOnly(64);
    }
}