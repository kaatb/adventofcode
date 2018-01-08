package adventofcode.day2;

import java.util.List;

class ChecksumLine {

    private final List<Integer> numbers;

    ChecksumLine(List<Integer> numbers) {
        this.numbers = numbers;
    }

    int getMaxMinChecksum() {
        return getMax() - getMin();
    }

    int getEvenlyDivisibleChecksum() {
        for (Integer number : numbers) {
            for (Integer divider : numbers) {
                if (!number.equals(divider) && number % divider == 0) {
                    return number / divider;
                }
            }
        }
        return 0;
    }

    private int getMax(){
        return numbers.stream().mapToInt(i -> i).max().getAsInt();
    }

    private int getMin(){
        return numbers.stream().mapToInt(i -> i).min().getAsInt();
    }
}
