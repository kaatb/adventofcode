package adventofcode.day1;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class CaptchaCalculatorTest {

    @Test
    public void captchaSum_AddsNumberIfNextNumberIsTheSame() {
        assertThat(new CaptchaCalculator().sum(Arrays.asList(new CaptchaNumber(1,1),
                new CaptchaNumber(1,2),
                new CaptchaNumber(2,2),
                new CaptchaNumber(2,1)))).isEqualTo(3);
    }

    @Test
    public void captchaSum_AllNumbersTheSame_AddsAll() {
        assertThat(new CaptchaCalculator().sum(newArrayList(
                new CaptchaNumber(1, 1),
                new CaptchaNumber(1, 1),
                new CaptchaNumber(1, 1),
                new CaptchaNumber(1, 1)))).isEqualTo(4);
    }

    @Test
    public void captchaSum_NoSameNumbers_ReturnsZero() {
        assertThat(new CaptchaCalculator().sum(newArrayList(
                new CaptchaNumber(1, 2),
                new CaptchaNumber(2, 3),
                new CaptchaNumber(3, 4),
                new CaptchaNumber(4, 1)))).isEqualTo(0);
    }
}
