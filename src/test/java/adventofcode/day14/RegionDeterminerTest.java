package adventofcode.day14;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RegionDeterminerTest {

    @Test
    public void determine_unusedBlocksAreNotPartOfARegion() {
        Block unusedBlock = new Block(0, 0, false);
        Block usedBlock = new Block(0, 1, true);

        new RegionDeterminer().determine(Arrays.asList(unusedBlock, usedBlock));

        assertThat(unusedBlock.isPartOfRegion()).isFalse();
        assertThat(usedBlock.isPartOfRegion()).isTrue();
    }

    @Test
    public void determine_region() {
        /*
        0 1 1
        2 0 1
        2 0 1
         */
        Block unusedBlock = new Block(0, 0, false);
        Block block1_Region2 = new Block(0, 1, true);
        Block block2_Region2 = new Block(0, 2, true);
        Block block1_Region1 = new Block(1, 0, true);
        Block unusedBlock2 = new Block(1, 1, false);
        Block unusedBlock3 = new Block(1, 2, false);
        Block block2_Region1 = new Block(2, 0, true);
        Block block3_Region1 = new Block(2, 1, true);
        Block block4_Region1 = new Block(2, 2, true);

        new RegionDeterminer().determine(Arrays.asList(unusedBlock, block1_Region1, block2_Region1,
                block1_Region2, unusedBlock2, block3_Region1,
                block2_Region2, unusedBlock3, block4_Region1));

        assertThat(unusedBlock.getRegion().isPresent()).isFalse();
        assertThat(unusedBlock2.getRegion().isPresent()).isFalse();
        assertThat(unusedBlock3.getRegion().isPresent()).isFalse();
        assertThat(block1_Region1.getRegion().get()).isEqualTo(1);
        assertThat(block2_Region1.getRegion().get()).isEqualTo(1);
        assertThat(block3_Region1.getRegion().get()).isEqualTo(1);
        assertThat(block4_Region1.getRegion().get()).isEqualTo(1);
        assertThat(block1_Region2.getRegion().get()).isEqualTo(2);
        assertThat(block2_Region2.getRegion().get()).isEqualTo(2);
    }
}