package adventofcode.day10;

import java.util.List;

class SublistReverser {

    List<Integer> reverse(List<Integer> list, Integer reverseLength, int reverseStart) {
        int firstPositionToSwitch;
        int lastPositionToSwitch;
        if (reverseStart + reverseLength - 1 < list.size()) {
            firstPositionToSwitch = reverseStart;
            lastPositionToSwitch = reverseStart + reverseLength - 1;
        } else {
            firstPositionToSwitch = reverseStart;
            lastPositionToSwitch = reverseLength - (list.size() - reverseStart) - 1;
        }

        int timesSwitched = 0;
        while (timesSwitched < ((Integer) (reverseLength / 2))) {
            int firstItem = list.get(firstPositionToSwitch);
            list.set(firstPositionToSwitch, list.get(lastPositionToSwitch));
            list.set(lastPositionToSwitch, firstItem);
            if (lastPositionToSwitch == 0) {
                lastPositionToSwitch = list.size() - 1;
            } else {
                lastPositionToSwitch--;
            }
            if (firstPositionToSwitch == list.size() - 1) {
                firstPositionToSwitch = 0;
            } else {
                firstPositionToSwitch++;
            }
            timesSwitched++;

        }
        return list;
    }
}
