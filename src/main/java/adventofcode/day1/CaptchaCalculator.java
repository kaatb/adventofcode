package adventofcode.day1;

import java.util.List;
import java.util.stream.Collectors;

public class CaptchaCalculator {

    public int sum(String captcha) {
        final CaptchaSum captchaSum = new CaptchaSum();

        mapToIntegerListWithRecurringFirstElement(captcha).stream()
                .reduce(0,(a,b) -> {
                    if(a.equals(b)){
                        captchaSum.add(a);
                    }
                    return b;
                });

        return captchaSum.sum;
    }

    private List<Integer> mapToIntegerListWithRecurringFirstElement(String captcha) {
        List<Integer> captchaNumberList = captcha.chars()
                .mapToObj(e -> Integer.parseInt(String.valueOf((char) e)))
                .collect(Collectors.toList());

        captchaNumberList.add(Integer.parseInt(captcha.substring(0,1)));
        return captchaNumberList;
    }

    private class CaptchaSum {
        private int sum;

        private void add(int number){
            sum+= number;
        }
    }
}
