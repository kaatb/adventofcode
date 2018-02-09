package adventofcode.day10;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class HashCalculator {

    private SublistReverser reverser = new SublistReverser();
    private Integer skipSize = 0;
    private Integer currentPosition = 0;

    public String knotHash(String input) {
        reset();
        List<Integer> inputAsIntegers = input.chars()
                .map(c -> (int) c)
                .mapToObj(i -> Integer.valueOf(i))
                .collect(Collectors.toList());
        inputAsIntegers.addAll(Arrays.asList(17, 31, 73, 47, 23));
        return knotHash(inputAsIntegers);
    }

    private void reset() {
        skipSize = 0;
        currentPosition = 0;
    }

    private String knotHash(List<Integer> lengthSequence) {
        List<Integer> list = createInitialList(256);
        for (int i = 0; i < 64; i++) {
            list = sparseHash(list, lengthSequence);
        }

        List<Integer> denseHash = calculateDenseHash(list);
        return denseHash.stream()
                .map(Integer::toHexString)
                .map(s -> StringUtils.leftPad(s, 2, "0"))
                .collect(Collectors.joining());
    }

    List<Integer> calculateDenseHash(List<Integer> list) {
        List<Integer> denseHashes = Lists.newArrayList();
        for (int i = 0; i < list.size() / 16; i++) {
            Integer dense = list.get(i * 16);
            for (int j = 1; j < 16; j++) {
                dense = dense ^ list.get(i * 16 + j);
            }
            denseHashes.add(dense);
        }
        return denseHashes;
    }

    public List<Integer> sparseHash(List<Integer> list, List<Integer> lengthSequence) {
        for (Integer length : lengthSequence) {
            list = reverser.reverse(list, length, currentPosition);
            currentPosition = calculateNewCurrentPosition(list, skipSize, currentPosition, length);
            skipSize++;
        }
        return list;
    }

    private Integer calculateNewCurrentPosition(List<Integer> list, Integer skipSize, Integer currentPosition, Integer length) {
        currentPosition = currentPosition + length + skipSize;
        while (currentPosition >= list.size()) {
            currentPosition = currentPosition - list.size();
        }
        return currentPosition;
    }

    private static List<Integer> createInitialList(int listLength) {
        List<Integer> list = newArrayList();
        for (int i = 0; i < listLength; i++) {
            list.add(i);
        }
        return list;
    }
}
