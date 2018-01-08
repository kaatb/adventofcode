package adventofcode.day1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CaptchaCalculatorTest {

    @Test
    public void captchaSum_AddsNumberIfNextNumberIsTheSame() {
        assertThat(new CaptchaCalculator().sum("1122")).isEqualTo(3);
    }

    @Test
    public void captchaSum_AllNumbersTheSame_AddsAll() {
        assertThat(new CaptchaCalculator().sum("1111")).isEqualTo(4);
    }

    @Test
    public void captchaSum_NoSameNumbers_ReturnsZero() {
        assertThat(new CaptchaCalculator().sum("1234")).isEqualTo(0);
    }

    @Test
    public void captchaSum_LastAndFirstNumberTheSame_AddsNumberToResult() {
        assertThat(new CaptchaCalculator().sum("91212129")).isEqualTo(9);
    }
}
