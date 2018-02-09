package adventofcode.day15;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {

    @Test
    public void check() {
        Judge judge = new Judge(new Generator(16807L, 4L, 65L),
                new Generator(48271L, 8L, 8921L));

        judge.check();
        judge.check();
        judge.check();
        judge.check();
        judge.check();

        assertThat(judge.getNumberOfMatches()).isEqualTo(1);
    }
}