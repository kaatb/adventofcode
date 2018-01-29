package adventofcode.day10;

import java.util.List;

class HashCalculator {

    private SublistReverser reverser = new SublistReverser();

    public Integer knotHash(List<Integer> list, List<Integer> lengthSequence) {
        Integer skipSize = 0;
        Integer currentPosition = 0;

        for (Integer length : lengthSequence) {
            list = reverser.reverse(list, length, currentPosition);
            currentPosition = calculateNewCurrentPosition(list, skipSize, currentPosition, length);
            skipSize++;
        }

        return list.get(0) * list.get(1);
    }

    private Integer calculateNewCurrentPosition(List<Integer> list, Integer skipSize, Integer currentPosition, Integer length) {
        currentPosition = currentPosition + length + skipSize;
        if (currentPosition >= list.size()) {
            currentPosition = currentPosition - list.size();
        }
        return currentPosition;
    }
}
