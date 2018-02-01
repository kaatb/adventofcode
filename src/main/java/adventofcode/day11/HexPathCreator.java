package adventofcode.day11;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class HexPathCreator {

    public List<Hexagon> create(List<HexAlignment> path) {
        List<Hexagon> hexagons = newArrayList();
        hexagons.add(new Hexagon(0, 0));
        for (HexAlignment hexAlignment : path) {
            Hexagon previous = hexagons.get(hexagons.size() - 1);
            int coordinateX = previous.getCoordinateX();
            int coordinateY = previous.getCoordinateY();
            switch (hexAlignment) {
                case SOUTH:
                    coordinateY++;
                    break;
                case NORTH:
                    coordinateY--;
                    break;
                case NORTH_EAST:
                    coordinateX++;
                    coordinateY--;
                    break;
                case NORTH_WEST:
                    coordinateX--;
                    break;
                case SOUTH_EAST:
                    coordinateX++;
                    break;
                case SOUTH_WEST:
                    coordinateX--;
                    coordinateY++;
                    break;
            }
            hexagons.add(new Hexagon(coordinateX, coordinateY));
        }
        return hexagons;
    }
}
