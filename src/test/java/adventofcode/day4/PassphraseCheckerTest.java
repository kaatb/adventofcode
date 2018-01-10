package adventofcode.day4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassphraseCheckerTest {

    @Test
    public void isValid_TrueIfNoDuplicates() {
        assertThat(new PassphraseChecker().isValid("aa bb cc dd ee")).isTrue();
    }

    @Test
    public void isValid_FalseIfDuplicates() {
        assertThat(new PassphraseChecker().isValid("aa bb cc dd aa")).isFalse();
    }

    @Test
    public void isValid_TrueIfNoDuplicates_ButSubDuplicates() {
        assertThat(new PassphraseChecker().isValid("aa bb cc dd aaa")).isTrue();
    }

    @Test
    public void isValid_TrueIfNoAnagrams() {
        assertThat(new PassphraseChecker().isValid("abcde fghij")).isTrue();
    }

    @Test
    public void isValid_FalseIfAnagrams() {
        assertThat(new PassphraseChecker().isValid("abcde xyz ecdab")).isFalse();
        assertThat(new PassphraseChecker().isValid("oiii ioii iioi iiio")).isFalse();
    }

    @Test
    public void isValid_TrueOnlyOnAnagramsUsingAllLetters() {
        assertThat(new PassphraseChecker().isValid("a ab abc abd abf abj")).isTrue();
        assertThat(new PassphraseChecker().isValid("iiii oiii ooii oooi oooo")).isTrue();
    }
}