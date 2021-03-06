package adventofcode.day2;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class ChecksumRunner {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readLines(new File("src/main/resources/day2.txt"), Charset.defaultCharset());

        System.out.println(new ChecksumResolver().resolveMaxMin(lines));
        System.out.println(new ChecksumResolver().resolveEvenlyDivisble(lines));
    }
}
