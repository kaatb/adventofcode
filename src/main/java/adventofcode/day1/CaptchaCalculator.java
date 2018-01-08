package adventofcode.day1;

import java.util.List;

public class CaptchaCalculator {

    public int sum(List<CaptchaNumber> captchaNumbers) {
        final CaptchaCalculator.CaptchaSum captchaSum = new CaptchaCalculator.CaptchaSum();
        captchaNumbers.stream()
                .forEach(captchaNumber -> {
                    if (captchaNumber.shouldBeAdded())
                        captchaSum.add(captchaNumber.getValue());
                });

        return captchaSum.sum;
    }

    private class CaptchaSum {
        private int sum;

        private void add(int number){
            sum+= number;
        }
    }
}
