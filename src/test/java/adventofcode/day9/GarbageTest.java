package adventofcode.day9;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GarbageTest {

    @Test
    public void getNonCanceledCharacters() {
        assertThat(new Garbage("<!!!>!<\"<!>,<!!!>!>},<!>,<'e\">").getNonCanceledCharacters()).isEqualTo(12);
    }

    @Test
    public void getNonCanceledCharacters_doesNotCountLeadingAndEndingCharacter() {
        assertThat(new Garbage("<>").getNonCanceledCharacters()).isEqualTo(0);
    }

    @Test
    public void getNonCanceledCharacters_countsAllCharactersInGarbageString() {
        assertThat(new Garbage("<abc>").getNonCanceledCharacters()).isEqualTo(3);
    }

    @Test
    public void getNonCanceledCharacters_doesNotCountCanceledCharacters() {
        assertThat(new Garbage("<!abc!d>").getNonCanceledCharacters()).isEqualTo(2);
    }
}