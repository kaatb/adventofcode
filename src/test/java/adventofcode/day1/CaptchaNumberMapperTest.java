package adventofcode.day1;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;

public class CaptchaNumberMapperTest {

    @Test
    public void mapOnNextElement() {
        ReflectionAssert.assertLenientEquals(
                Arrays.asList(
                        new CaptchaNumber(1,2),
                        new CaptchaNumber(2,3),
                        new CaptchaNumber(3,4),
                        new CaptchaNumber(4,1)
                ),
                new CaptchaNumberMapper().mapOnNextElement(newArrayList(1,2,3,4)));
    }

    @Test
    public void mapOnElementHalfwayRound() {
        ReflectionAssert.assertLenientEquals(
                Arrays.asList(
                        new CaptchaNumber(1,3),
                        new CaptchaNumber(2,4),
                        new CaptchaNumber(3,1),
                        new CaptchaNumber(4,2)
                ),
                new CaptchaNumberMapper().mapOnElementHalfwayRound(newArrayList(1,2,3,4)));
    }
}