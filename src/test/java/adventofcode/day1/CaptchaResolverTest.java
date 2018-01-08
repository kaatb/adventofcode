package adventofcode.day1;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CaptchaResolverTest {

    private CaptchaResolver captchaResolver;

    @Before
    public void setUp() {
        captchaResolver = new CaptchaResolver();
    }

    @Test
    public void resolveOnNextElement() {
        assertThat(captchaResolver.resolveOnNextElement("1122")).isEqualTo(3);
        assertThat(captchaResolver.resolveOnNextElement("1111")).isEqualTo(4);
        assertThat(captchaResolver.resolveOnNextElement("1234")).isEqualTo(0);
        assertThat(captchaResolver.resolveOnNextElement("91212129")).isEqualTo(9);
    }

    @Test
    public void resolveOnElementHalfwayRound() {
        assertThat(captchaResolver.resolveOnElementHalfwayRound("1212")).isEqualTo(6);
        assertThat(captchaResolver.resolveOnElementHalfwayRound("1221")).isEqualTo(0);
        assertThat(captchaResolver.resolveOnElementHalfwayRound("123425")).isEqualTo(4);
        assertThat(captchaResolver.resolveOnElementHalfwayRound("123123")).isEqualTo(12);
        assertThat(captchaResolver.resolveOnElementHalfwayRound("12131415")).isEqualTo(4);
    }
}