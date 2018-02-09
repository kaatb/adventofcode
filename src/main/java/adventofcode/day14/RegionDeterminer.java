package adventofcode.day14;

import java.util.List;

class RegionDeterminer {

    public void determine(List<Block> blocks) {
        int region = 1;
        determineNextRegion(region, blocks);
    }

    private void determineNextRegion(final int region, List<Block> blocks) {
        blocks.stream()
                .filter(Block::isUsed)
                .filter(block -> !block.isPartOfRegion())
                .findFirst()
                .ifPresent(block -> {
                    block.setRegion(region);
                    setNeighbouringRegionBlocks(block, blocks);
                    determineNextRegion(region + 1, blocks);
                });
    }

    private void setNeighbouringRegionBlocks(Block currentBlock, List<Block> blocks) {
        blocks.stream()
                .filter(block -> block.isUsed() && !block.isPartOfRegion())
                .filter(block -> block.isNeighbour(currentBlock))
                .forEach(block -> {
                    block.setRegion(currentBlock.getRegion().get());
                    setNeighbouringRegionBlocks(block, blocks);
                });
    }
}
