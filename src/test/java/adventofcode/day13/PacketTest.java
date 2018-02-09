package adventofcode.day13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.unitils.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PacketTest {

    @Mock
    private Layer layer1, layer2;

    @Test
    public void isCaughtInCurrentLayer_caught() {
        Packet packet = new Packet();
        packet.setCurrentLayer(Optional.of(layer1));
        when(layer1.isCaught()).thenReturn(true);

        assertThat(packet.checkCaughtInCurrentLayer()).isTrue();
        assertThat(packet.getLayersWhereCaught()).containsOnly(layer1);
    }

    @Test
    public void isCaughtInCurrentLayer_notCaught() {
        Packet packet = new Packet();
        packet.setCurrentLayer(Optional.of(layer1));

        when(layer1.isCaught()).thenReturn(false);

        assertThat(packet.checkCaughtInCurrentLayer()).isFalse();
        assertThat(packet.getLayersWhereCaught()).isEmpty();
    }

    @Test
    public void isCaughtInCurrentLayer_nonSpecifiedLayer() {
        Packet packet = new Packet();
        packet.setCurrentLayer(Optional.empty());

        assertThat(packet.checkCaughtInCurrentLayer()).isFalse();
        assertThat(packet.getLayersWhereCaught()).isEmpty();
    }

    @Test
    public void getSeverityOfTrip() throws Exception {
        when(layer1.getSeverity()).thenReturn(6L);
        when(layer2.getSeverity()).thenReturn(8L);

        Packet packet = new Packet();
        ReflectionUtils.setFieldValue(packet, "layersWhereCaught", Arrays.asList(layer1, layer2));

        assertThat(packet.getSeverityOfTrip()).isEqualTo(14L);
    }
}