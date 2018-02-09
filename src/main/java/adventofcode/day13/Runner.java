package adventofcode.day13;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Runner {

    public static void main(String[] args) throws IOException {
        List<LayerInputLine> layerInputLines = Files.readLines(new File("src/main/resources/day13.txt"), Charset.defaultCharset())
                .stream()
                .map(LayerInputLine::new)
                .collect(toList());

        List<Layer> layers = layerInputLines.stream()
                .map(input -> new Layer(input.getDepth(), input.getRange()))
                .collect(toList());

        Packet packet = new Packet();
        new LayerScanner(layers).scan(packet);

        System.out.println(packet.getSeverityOfTrip());
    }
}
