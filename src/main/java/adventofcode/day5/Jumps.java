package adventofcode.day5;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.function.Function;

public class Jumps {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readLines(new File("src/main/resources/day5.txt"), Charset.defaultCharset());

        System.out.println(new JumpCalculator().calculate(new JumpSequence(lines), increaseBy1()));
        System.out.println(new JumpCalculator().calculate(new JumpSequence(lines), increaseOrDecreaseBy1()));
    }

    static Function<Integer, Integer> increaseBy1() {
        return value -> value + 1;
    }

    static Function<Integer, Integer> increaseOrDecreaseBy1() {
        return value -> value < 3 ? value + 1 : value - 1;
    }
}
