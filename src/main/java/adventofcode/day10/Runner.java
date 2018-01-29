package adventofcode.day10;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class Runner {

    public static void main(String[] args) throws IOException {
        List<Integer> lengthSequence = Files.readLines(new File("src/main/resources/day10.txt"), Charset.defaultCharset())
                .stream()
                .map(line -> Arrays.stream(line.split(","))
                        .map(Integer::parseInt)
                        .collect(toList()))
                .findFirst()
                .get();
        List<Integer> list = createInitialList(256);

        System.out.println(new HashCalculator().knotHash(list, lengthSequence));

    }

    private static List<Integer> createInitialList(int listLength) {
        List<Integer> list = newArrayList();
        for (int i = 0; i < listLength; i++) {
            list.add(i);
        }
        return list;
    }


}
