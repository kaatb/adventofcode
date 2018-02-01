package adventofcode.day11;

import java.util.Comparator;
import java.util.List;

class HexPathDistanceCalculator {

    public int getNumberOfStepsOfOptimizedPath(List<Hexagon> path) {
        Hexagon lastHexagon = path.get(path.size() - 1);
        return lastHexagon.getMaxStepsFromCenter();
    }

    public int getFurthestDistanceFromStartingPoint(List<Hexagon> hexagonList) {
        return hexagonList.stream()
                .max(Comparator.comparingInt(Hexagon::getMaxStepsFromCenter))
                .get()
                .getMaxStepsFromCenter();
    }
}
