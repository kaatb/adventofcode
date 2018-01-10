package adventofcode.day6;

import com.google.common.collect.Lists;

import java.util.List;

import static java.util.stream.Collectors.toList;

class MemoryBankReallocator {

    public int reallocateUntilHistoryRepeatsItself(List<MemoryBank> memoryBanks) {
        List<List<Integer>> historyOfMemoryBanks = Lists.newArrayList();

        while (!historyOfMemoryBanks.contains(getMemoryBanksForHistory(memoryBanks))) {
            historyOfMemoryBanks.add(getMemoryBanksForHistory(memoryBanks));
            reallocate(memoryBanks);
        }

        return historyOfMemoryBanks.size();
    }

    private List<Integer> getMemoryBanksForHistory(List<MemoryBank> memoryBanks) {
        return memoryBanks.stream().map(MemoryBank::getBlocks).collect(toList());
    }

    void reallocate(List<MemoryBank> memoryBanks) {
        Integer maxAmountOfBlocks = getMaxAmountOfBlocksInAllMemoryBanks(memoryBanks);

        boolean hasBeenReset = false;
        while (maxAmountOfBlocks > 0) {
            for (MemoryBank memoryBank : memoryBanks) {
                if (!hasBeenReset) {
                    if (isMemoryBankToBeReset(maxAmountOfBlocks, memoryBank)) {
                        memoryBank.reset();
                        hasBeenReset = true;
                    }
                } else {
                    maxAmountOfBlocks = reallocateBlock(maxAmountOfBlocks, memoryBank);
                }
            }
        }


    }

    private boolean isMemoryBankToBeReset(Integer maxAmountOfBlocks, MemoryBank memoryBank) {
        return memoryBank.getBlocks().equals(maxAmountOfBlocks);
    }

    private Integer getMaxAmountOfBlocksInAllMemoryBanks(List<MemoryBank> memoryBanks) {
        return memoryBanks.stream().max((a, b) -> (a.getBlocks().compareTo(b.getBlocks()))).get().getBlocks();
    }

    private Integer reallocateBlock(Integer maxAmountOfBlocks, MemoryBank memoryBank) {
        if (maxAmountOfBlocks > 0) {
            memoryBank.addBlock();
            maxAmountOfBlocks--;
        }
        return maxAmountOfBlocks;
    }
}
