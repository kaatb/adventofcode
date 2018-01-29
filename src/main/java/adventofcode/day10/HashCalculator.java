package adventofcode.day10;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

class HashCalculator {

    private SublistReverser reverser = new SublistReverser();
    private Integer skipSize = 0;
    private Integer currentPosition = 0;

    public String knotHash(List<Integer> list, List<Integer> lengthSequence, int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            list = sparseHash(list, lengthSequence);
        }

        List<Integer> denseHash = calculateDenseHash(list);
        return denseHash.stream()
                .map(Integer::toHexString)
                .map(s -> s.length() < 2 ? "0" + s : s)
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
}
