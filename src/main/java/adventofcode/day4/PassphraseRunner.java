package adventofcode.day4;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class PassphraseRunner {

    public static void main(String[] args) throws IOException {
        PassphraseChecker passphraseChecker = new PassphraseChecker();
        List<String> lines = Files.readLines(new File("src/main/resources/day4.txt"), Charset.defaultCharset());

        System.out.println(lines.stream()
                .filter(passphraseChecker::isValid)
                .count());
    }
}
