package adventofcode.day6;

class MemoryBank {

    private Integer blocks;

    MemoryBank(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void reset() {
        this.blocks = 0;
    }

    public void addBlock() {
        this.blocks++;
    }
}
