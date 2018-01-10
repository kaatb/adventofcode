package adventofcode.day6;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryBankReallocatorTest {

    private MemoryBankReallocator reallocator = new MemoryBankReallocator();

    @Test
    public void reallocate() {
        List<MemoryBank> memoryBanks = Arrays.asList(new MemoryBank(0),
                new MemoryBank(2),
                new MemoryBank(7),
                new MemoryBank(0));

        reallocator.reallocate(memoryBanks);
        assertMemoryBankBlocks(memoryBanks, Arrays.asList(2, 4, 1, 2));

        reallocator.reallocate(memoryBanks);
        assertMemoryBankBlocks(memoryBanks, Arrays.asList(3, 1, 2, 3));

        reallocator.reallocate(memoryBanks);
        assertMemoryBankBlocks(memoryBanks, Arrays.asList(0, 2, 3, 4));

        reallocator.reallocate(memoryBanks);
        assertMemoryBankBlocks(memoryBanks, Arrays.asList(1, 3, 4, 1));

        reallocator.reallocate(memoryBanks);
        assertMemoryBankBlocks(memoryBanks, Arrays.asList(2, 4, 1, 2));
    }

    @Test
    public void reallocateUntilHistoryRepeatsItself() {
        List<MemoryBank> memoryBanks = Arrays.asList(new MemoryBank(0),
                new MemoryBank(2),
                new MemoryBank(7),
                new MemoryBank(0));

        assertThat(reallocator.reallocateUntilHistoryRepeatsItself(memoryBanks).getNumberOfCycles()).isEqualTo(5);
    }

    private void assertMemoryBankBlocks(List<MemoryBank> memoryBanks, List<Integer> expected) {
        assertThat(memoryBanks.get(0).getBlocks()).isEqualTo(expected.get(0));
        assertThat(memoryBanks.get(1).getBlocks()).isEqualTo(expected.get(1));
        assertThat(memoryBanks.get(2).getBlocks()).isEqualTo(expected.get(2));
        assertThat(memoryBanks.get(3).getBlocks()).isEqualTo(expected.get(3));
    }
}