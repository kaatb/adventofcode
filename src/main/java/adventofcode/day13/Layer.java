package adventofcode.day13;

import static adventofcode.day13.Direction.DOWN;
import static adventofcode.day13.Direction.UP;

class Layer {

    private final Long depth;
    private final Long range;
    private Long securityScanner = 0L;
    private Direction directionOfScanner = DOWN;

    Layer(Long depth, Long range) {
        this.depth = depth;
        this.range = range;
    }

    void scan() {
        if (DOWN.equals(directionOfScanner)) {
            securityScanner++;
        } else {
            securityScanner--;
        }
        setDirectionOfScanner();
    }

    private void setDirectionOfScanner() {
        if (securityScanner == 0) {
            directionOfScanner = DOWN;
        } else if (securityScanner == range - 1) {
            directionOfScanner = UP;
        }
    }

    boolean isCaught() {
        return securityScanner == 0L;
    }

    Long getSecurityScanner() {
        return securityScanner;
    }

    Long getSeverity() {
        return depth * range;
    }

    Long getDepth() {
        return depth;
    }
}
