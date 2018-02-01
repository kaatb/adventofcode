package adventofcode.day11;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class HexEdRunner {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readLines(new File("src/main/resources/day11.txt"), Charset.defaultCharset())
                .stream()
                .collect(toList());

        List<HexAlignment> path = new HexPathParser().parse(input.get(0));
        List<Hexagon> hexagonList = new HexPathCreator().create(path);

        System.out.println(new HexPathOptimizer().getNumberOfStepsInOptimizedPath(path));

        System.out.println(new HexPathDistanceCalculator().getNumberOfStepsOfOptimizedPath(hexagonList));
        System.out.println(new HexPathDistanceCalculator().getFurthestDistanceFromStartingPoint(hexagonList));
    }
}
