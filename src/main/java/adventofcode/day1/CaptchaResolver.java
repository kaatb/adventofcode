package adventofcode.day1;

import java.util.List;

public class CaptchaResolver {

    public int resolveOnNextElement(String captcha){
        List<Integer> captchaAsIntegers = new CaptchaFormatter().format(captcha);

        List<CaptchaNumber> toCheckOnNextElement = new CaptchaNumberMapper().mapOnNextElement(captchaAsIntegers);
        return new CaptchaCalculator().sum(toCheckOnNextElement);
    }

    public int resolveOnElementHalfwayRound(String captcha) {
        List<Integer> captchaAsIntegers = new CaptchaFormatter().format(captcha);

        List<CaptchaNumber> captchaNumberList = new CaptchaNumberMapper().mapOnElementHalfwayRound(captchaAsIntegers);
        return new CaptchaCalculator().sum(captchaNumberList);
    }
}
