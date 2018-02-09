package adventofcode.day10;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Part2Runner {

    public static void main(String[] args) throws IOException {
        String inputFromFile = Files.readLines(new File("src/main/resources/day10.txt"), Charset.defaultCharset()).get(0);
        System.out.println(new HashCalculator().knotHash(inputFromFile));
    }
}
