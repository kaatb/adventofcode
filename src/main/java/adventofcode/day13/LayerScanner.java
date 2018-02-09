package adventofcode.day13;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LayerScanner {

    private List<Layer> layers;

    LayerScanner(List<Layer> layers) {
        this.layers = layers;
    }

    void scan(Packet packet) {
        for (long i = 0L; i <= getMaxLayer().getDepth(); i++) {
            packet.setCurrentLayer(getLayer(i));
            packet.checkCaughtInCurrentLayer();
            layers.forEach(Layer::scan);
        }
    }

    Long scan2() {
        return layers.stream()
                .mapToLong(layer -> layer.willCatchIntruder(0L) ? layer.getSeverity() : 0)
                .reduce((a, b) -> a + b)
                .getAsLong();
    }

    Long getWaitTimeForNotGettingCaught() {
        boolean caught = true;
        Long wait = -1L;
        while (caught) {
            wait++;
            caught = false;
            for (Layer layer : layers) {
                caught = layer.willCatchIntruder(wait);
                if (caught) {
                    break;
                }
            }
        }
        return wait;
    }

    private Optional<Layer> getLayer(Long depth) {
        return layers.stream().filter(layer -> depth.equals(layer.getDepth())).findFirst();
    }

    private Layer getMaxLayer() {
        return layers.stream()
                .max(Comparator.comparing(Layer::getDepth))
                .get();
    }
}
