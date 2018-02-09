package adventofcode.day14;

import java.util.Optional;

class Block {

    private final int x;
    private final int y;
    private boolean used;
    private Integer region;

    Block(int x, int y, boolean used) {
        this.x = x;
        this.y = y;
        this.used = used;
    }

    boolean isNeighbour(Block neighbouringBlock) {
        return (neighbouringBlock.getX() == x && (neighbouringBlock.getY() == y - 1 || neighbouringBlock.getY() == y + 1))
                || (neighbouringBlock.getY() == y && (neighbouringBlock.getX() == x - 1 || neighbouringBlock.getX() == x + 1));
    }

    boolean isUsed() {
        return used;
    }

    void setRegion(Integer region) {
        this.region = region;
    }

    boolean isPartOfRegion() {
        return region != null;
    }

    Optional<Integer> getRegion() {
        return Optional.ofNullable(region);
    }

    private int getX() {
        return x;
    }

    private int getY() {
        return y;
    }
}
