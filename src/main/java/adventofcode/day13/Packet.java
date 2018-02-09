package adventofcode.day13;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;

public class Packet {

    private Optional<Layer> currentLayer;
    private List<Layer> layersWhereCaught = newArrayList();

    public void setCurrentLayer(Optional<Layer> currentLayer) {
        this.currentLayer = currentLayer;
    }

    boolean isCaughtInCurrentLayer() {
        if (currentLayer.isPresent() && currentLayer.get().isCaught()) {
            layersWhereCaught.add(currentLayer.get());
            return true;
        } else {
            return false;
        }
    }

    Long getSeverityOfTrip() {
        return layersWhereCaught.stream()
                .map(Layer::getSeverity)
                .reduce((a, b) -> a + b)
                .get();
    }

    List<Layer> getLayersWhereCaught() {
        return layersWhereCaught;
    }
}
