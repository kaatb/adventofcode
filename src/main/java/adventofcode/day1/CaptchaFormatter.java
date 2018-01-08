package adventofcode.day1;

import java.util.List;
import java.util.stream.Collectors;

public class CaptchaFormatter {

    public List<Integer> format(String captcha){
        return captcha.chars()
                .mapToObj(e -> Integer.parseInt(String.valueOf((char) e)))
                .collect(Collectors.toList());
    }
}
