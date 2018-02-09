package adventofcode.day14;

import adventofcode.day10.HashCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class Runner {

    public static void main(String[] args) {
        List<String> input = createInput("jzgqcdpd", 128);
        List<String> bitsList = convertInputToBits(input);
        List<Block> blocks = convertToListOfBlocks(bitsList);

        System.out.println(blocks.stream()
                .filter(Block::isUsed)
                .count());

        new RegionDeterminer().determine(blocks);
        System.out.println(blocks.stream()
                .max(Comparator.comparing(a -> a.getRegion().orElse(0))).get()
                .getRegion().get());
    }

    private static List<Block> convertToListOfBlocks(List<String> bitsList) {
        List<Block> blocks = newArrayList();
        for (int y = 0; y < bitsList.size(); y++) {
            for (int x = 0; x < bitsList.get(y).length(); x++) {
                blocks.add(new Block(x, y, Integer.parseInt(bitsList.get(y).substring(x, x + 1)) == 1));
            }
        }
        return blocks;
    }

    private static List<String> convertInputToBits(List<String> input) {
        return input.stream()
                .map(inputString -> {
                    return new HexadecimalToBinaryConverter().convert(new HashCalculator().knotHash(inputString));
                })
                .collect(Collectors.toList());
    }

    private static List<String> createInput(String inputString, int amount) {
        ArrayList<String> input = newArrayList();
        for (int i = 0; i < amount; i++) {
            input.add(inputString + "-" + i);
        }
        return input;
    }
}
