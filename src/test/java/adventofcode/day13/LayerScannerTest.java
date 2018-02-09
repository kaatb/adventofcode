package adventofcode.day13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LayerScannerTest {

    @Mock
    private Packet packet;

    @Mock
    private Layer layer0, layer1, layer6;

    @Test
    public void scan() {
        when(layer0.getDepth()).thenReturn(0L);
        when(layer1.getDepth()).thenReturn(1L);
        when(layer6.getDepth()).thenReturn(6L);
        LayerScanner scanner = new LayerScanner(asList(layer0, layer1, layer6));

        scanner.scan(packet);

        verify(packet, times(7)).setCurrentLayer(any());
        verify(packet, times(7)).isCaughtInCurrentLayer();
        verify(layer0, times(7)).scan();
        verify(layer1, times(7)).scan();
        verify(layer6, times(7)).scan();
    }
}