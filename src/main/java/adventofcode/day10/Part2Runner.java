package adventofcode.day10;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class Part2Runner {

    public static void main(String[] args) throws IOException {
        List<Integer> lengthSequence = readInput();
        lengthSequence.addAll(Arrays.asList(17, 31, 73, 47, 23));
        List<Integer> list = createInitialList(256);

        System.out.println(new HashCalculator().knotHash(list, lengthSequence, 64));
    }

    private static List<Integer> readInput() throws IOException {
        return Files.readLines(new File("src/main/resources/day10.txt"), Charset.defaultCharset())
                .stream()
                .map(line -> line.chars()
                        .map(c -> (int) c)
                        .mapToObj(i -> Integer.valueOf(i))
                        .collect(Collectors.toList()))
                .findFirst()
                .get();
    }

    private static List<Integer> createInitialList(int listLength) {
        List<Integer> list = newArrayList();
        for (int i = 0; i < listLength; i++) {
            list.add(i);
        }
        return list;
    }
}
