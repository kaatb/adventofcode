package adventofcode.day1;

import java.util.List;

class CaptchaResolver {

    int resolveOnNextElement(String captcha){
        List<Integer> captchaAsIntegers = new CaptchaFormatter().format(captcha);

        List<CaptchaNumber> toCheckOnNextElement = new CaptchaNumberMapper().mapOnNextElement(captchaAsIntegers);
        return new CaptchaCalculator().sum(toCheckOnNextElement);
    }

    int resolveOnElementHalfwayRound(String captcha) {
        List<Integer> captchaAsIntegers = new CaptchaFormatter().format(captcha);

        List<CaptchaNumber> captchaNumberList = new CaptchaNumberMapper().mapOnElementHalfwayRound(captchaAsIntegers);
        return new CaptchaCalculator().sum(captchaNumberList);
    }
}
