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
}