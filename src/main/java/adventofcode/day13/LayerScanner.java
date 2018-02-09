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
            packet.isCaughtInCurrentLayer();
            layers.forEach(Layer::scan);
        }
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
