package adventofcode.day9;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamRunner {

    public static void main(String[] args) throws IOException {
        List<String> streamOfChars = Files.readLines(new File("src/main/resources/day9.txt"), Charset.defaultCharset())
                .stream()
                .collect(toList());
        Group stream = new StreamWithGarbageParser().parseStream(streamOfChars.get(0));
        System.out.println(stream.getScore(0));
        System.out.println(stream.getNonCanceledCharactersCount());
    }
}
