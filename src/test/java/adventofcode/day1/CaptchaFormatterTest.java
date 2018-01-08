package adventofcode.day1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CaptchaFormatterTest {

    @Test
    public void format() {
        assertThat(new CaptchaFormatter().format("1234")).containsExactly(1,2,3,4);
    }
}