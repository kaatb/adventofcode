package adventofcode.day1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CaptchaNumberMapper {

    List<CaptchaNumber>  mapOnNextElement(List<Integer> captcha) {
        return IntStream.range(0, captcha.size())
                .mapToObj(index -> {
                    if (index == captcha.size() - 1) {
                        return new CaptchaNumber(captcha.get(index), captcha.get(0));
                    } else {
                        return new CaptchaNumber(captcha.get(index), captcha.get(index + 1));
                    }
                })
                .collect(Collectors.toList());


    }

    List<CaptchaNumber> mapOnElementHalfwayRound(List<Integer> captcha) {
        int halfwayRoundIndex = captcha.size() / 2;
        return IntStream.range(0, captcha.size())
                .mapToObj(index -> {
                    if (index+halfwayRoundIndex > captcha.size() - 1) {
                        return new CaptchaNumber(captcha.get(index), captcha.get(halfwayRoundIndex - (captcha.size() - index)));
                    } else {
                        return new CaptchaNumber(captcha.get(index), captcha.get(index + halfwayRoundIndex));
                    }
                })
                .collect(Collectors.toList());
    }
}