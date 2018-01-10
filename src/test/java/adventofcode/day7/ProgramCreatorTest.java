package adventofcode.day7;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;

import static java.util.Arrays.asList;

public class ProgramCreatorTest {

    @Test
    public void createAllPrograms() {
        List<Program> actual = new ProgramCreator().createAllPrograms(asList(
                new ProgramInputLine("ktlj (57)"),
                new ProgramInputLine("fwft (72) -> ktlj, cntj, xhth")));

        ReflectionAssert.assertLenientEquals(asList(
                new Program(57, "ktlj"),
                new Program(72, "fwft")), actual);
    }
}