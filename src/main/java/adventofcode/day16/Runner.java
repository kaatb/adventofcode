package adventofcode.day16;

import com.google.common.io.Files;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) throws Exception {
        List<DanceMove> danceInput = Arrays.stream(
                Files.readLines(new File("src/main/resources/day16.txt"), Charset.defaultCharset())
                        .stream()
                        .findFirst().get()
                        .split(","))
                .map(danceMove -> new DanceMoveMapper().map(danceMove))
                .collect(Collectors.toList());

        DanceGroup danceGroup = createDanceGroup();
        doDanceXTimes(danceGroup, danceInput, 1);
        System.out.println(danceGroup);

        int i = calculateDanceCycle(danceInput);

        danceGroup = createDanceGroup();
        doDanceXTimes(danceGroup, danceInput, 1000000000 % i);
        System.out.println(danceGroup);
    }

    private static int calculateDanceCycle(List<DanceMove> danceInput) {
        int i = 0;
        DanceGroup danceGroup = createDanceGroup();
        while (i == 0 || !danceGroup.getPrograms().equals(createDanceGroup().getPrograms())) {
            i++;
            danceGroup.doDance(danceInput);
        }
        return i;
    }

    private static void doDanceXTimes(DanceGroup danceGroup, List<DanceMove> danceInput, int times) {
        for (int j = 0; j < times; j++) {
            danceGroup.doDance(danceInput);
        }
    }

    private static DanceGroup createDanceGroup() {
        return new DanceGroup(Arrays.asList(new Program("a", 0),
                new Program("b", 1),
                new Program("c", 2),
                new Program("d", 3),
                new Program("e", 4),
                new Program("f", 5),
                new Program("g", 6),
                new Program("h", 7),
                new Program("i", 8),
                new Program("j", 9),
                new Program("k", 10),
                new Program("l", 11),
                new Program("m", 12),
                new Program("n", 13),
                new Program("o", 14),
                new Program("p", 15)));
    }
}
