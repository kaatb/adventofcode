package adventofcode.day17;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpinnerTest {

    @Test
    public void spin_0times() {
        Value actual = new Spinner(3).spin(0).get(0);
        assertValues(actual, 0);
    }

    @Test
    public void spin_1times() {
        Value actual = new Spinner(3).spin(1).get(0);
        assertValues(actual, 0, 1);
    }

    @Test
    public void spin_2times() {
        Value actual = new Spinner(3).spin(2).get(0);
        assertValues(actual, 0, 2, 1);
    }

    @Test
    public void spin_3times() {
        Value actual = new Spinner(3).spin(3).get(0);
        assertValues(actual, 0, 2, 3, 1);
    }

    @Test
    public void spin_7times() {
        Value actual = new Spinner(3).spin(7).get(0);
        assertValues(actual, 0, 5, 7, 2, 4, 3, 6, 1);
    }

    @Test
    public void spin_9times() {
        Value actual = new Spinner(3).spin(9).get(0);
        assertValues(actual, 0, 9, 5, 7, 2, 4, 3, 8, 6, 1);
    }

    @Test
    public void findElementAtIndex1After_0times() {
        Integer actual = new Spinner(3).findElementAtIndex1After(0);
        assertThat(actual).isNull();
    }

    @Test
    public void findElementAtIndex1After_1times() {
        Integer actual = new Spinner(3).findElementAtIndex1After(1);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void findElementAtIndex1After_2times() {
        Integer actual = new Spinner(3).findElementAtIndex1After(2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void findElementAtIndex1After_3times() {
        Integer actual = new Spinner(3).findElementAtIndex1After(3);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void findElementAtIndex1After_7times() {
        Integer actual = new Spinner(3).findElementAtIndex1After(7);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void findElementAtIndex1After_9times() {
        Integer actual = new Spinner(3).findElementAtIndex1After(9);
        assertThat(actual).isEqualTo(9);
    }


    private void assertValues(Value actual, Integer... expectedValues) {
        for (Integer expectedValue : expectedValues) {
            assertThat(actual.getValue()).isEqualTo(expectedValue);
            actual = actual.getNextValue();
        }
        assertThat(actual.getValue()).isEqualTo(expectedValues[0]);
    }
}