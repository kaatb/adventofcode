package adventofcode.day11;

import java.util.Arrays;

enum HexAlignment {

    SOUTH("s"),
    NORTH("n"),
    NORTH_EAST("ne"),
    NORTH_WEST("nw"),
    SOUTH_EAST("se"),
    SOUTH_WEST("sw");

    private String direction;

    HexAlignment(String direction) {
        this.direction = direction;
    }

    HexAlignment getDirectOpposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case NORTH_EAST:
                return SOUTH_WEST;
            case NORTH_WEST:
                return SOUTH_EAST;
            case SOUTH_EAST:
                return NORTH_WEST;
            case SOUTH_WEST:
                return NORTH_EAST;
        }
        throw new IllegalArgumentException();
    }

    HexAlignment getIndirectOpposite() {
        switch (this) {
            case NORTH:
                return SOUTH_EAST;
            case SOUTH:
                return NORTH_WEST;
            case NORTH_EAST:
                return SOUTH;
            case NORTH_WEST:
                return NORTH_EAST;
            case SOUTH_EAST:
                return SOUTH_WEST;
            case SOUTH_WEST:
                return NORTH;
        }
        throw new IllegalArgumentException();
    }

    HexAlignment getIndirectOppositeResult() {
        switch (this) {
            case NORTH:
                return NORTH_EAST;
            case SOUTH:
                return SOUTH_WEST;
            case NORTH_EAST:
                return SOUTH_EAST;
            case NORTH_WEST:
                return NORTH;
            case SOUTH_EAST:
                return SOUTH;
            case SOUTH_WEST:
                return NORTH_WEST;
        }
        throw new IllegalArgumentException();
    }

    public static HexAlignment forDirection(String direction) {
        return Arrays.stream(values())
                .filter(a -> a.direction.equals(direction))
                .findFirst()
                .get();
    }
}
