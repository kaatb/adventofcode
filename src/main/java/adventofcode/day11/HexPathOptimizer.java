package adventofcode.day11;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class HexPathOptimizer {

    public Long getNumberOfStepsInOptimizedPath(List<HexAlignment> path) {
        Map<HexAlignment, Long> hexAlignmentLongMap = orderPathPerHexAlignment(path);
        eliminateDirectOpposites(hexAlignmentLongMap);
        eliminateIndirectOpposites(hexAlignmentLongMap);
        return hexAlignmentLongMap.values().stream().reduce((a, b) -> a + b).get();
    }

    private Map<HexAlignment, Long> orderPathPerHexAlignment(List<HexAlignment> path) {
        Map<HexAlignment, Long> hexAlignmentCount = Maps.newHashMap();

        Arrays.stream(HexAlignment.values())
                .forEach(hexAlignment ->
                        hexAlignmentCount.put(hexAlignment, path.stream()
                                .filter(a -> a.equals(hexAlignment))
                                .count())
                );
        return hexAlignmentCount;
    }

    private void eliminateDirectOpposites(Map<HexAlignment, Long> path) {
        path.keySet().stream()
                .forEach(hexalignment -> {
                    HexAlignment opposite = hexalignment.getDirectOpposite();
                    long min = Math.min(path.get(hexalignment), path.get(opposite));
                    path.put(hexalignment, path.get(hexalignment) - min);
                    path.put(opposite, path.get(opposite) - min);
                });
    }

    private void eliminateIndirectOpposites(Map<HexAlignment, Long> path) {
        path.keySet().stream()
                .forEach(hexalignment -> {
                    HexAlignment opposite = hexalignment.getIndirectOpposite();
                    long min = Math.min(path.get(hexalignment), path.get(opposite));
                    path.put(hexalignment, path.get(hexalignment) - min);
                    path.put(opposite, path.get(opposite) - min);
                    path.put(hexalignment.getIndirectOppositeResult(), path.get(hexalignment.getIndirectOppositeResult()) + min);
                });
    }
}
