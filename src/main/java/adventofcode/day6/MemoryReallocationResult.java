package adventofcode.day6;

import com.google.common.collect.Lists;

import java.util.List;

class MemoryReallocationResult {

    private List<List<Integer>> historyOfMemoryBanks = Lists.newArrayList();

    void addHistory(List<Integer> memoryBanksState) {
        historyOfMemoryBanks.add(memoryBanksState);
    }

    boolean historyContains(List<Integer> memoryBanksStateToCheck) {
        return historyOfMemoryBanks.contains(memoryBanksStateToCheck);
    }

    public int getNumberOfCycles() {
        return historyOfMemoryBanks.size() - 1;
    }

    public int getLoopSize() {
        List<Integer> lastElementOfLoop = historyOfMemoryBanks.get(historyOfMemoryBanks.size() - 1);
        List<Integer> startElementOfLoop = historyOfMemoryBanks.stream()
                .filter(a -> a.equals(lastElementOfLoop))
                .findFirst()
                .get();
        historyOfMemoryBanks.indexOf(startElementOfLoop);
        return (historyOfMemoryBanks.size() - 1) - historyOfMemoryBanks.indexOf(startElementOfLoop);
    }
}
