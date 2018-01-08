package adventofcode.day2;

import java.util.List;

class ChecksumLine {

    private final List<Integer> numbers;

    ChecksumLine(List<Integer> numbers) {
        this.numbers = numbers;
    }

    int getChecksum() {
        return getMax() - getMin();
    }

    private int getMax(){
        return numbers.stream().mapToInt(i -> i).max().getAsInt();
    }

    private int getMin(){
        return numbers.stream().mapToInt(i -> i).min().getAsInt();
    }
}
