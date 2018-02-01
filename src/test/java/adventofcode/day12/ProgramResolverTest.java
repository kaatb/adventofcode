package adventofcode.day12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProgramResolverTest {

    @Mock
    private Program program_0;
    @Mock
    private Program program_1;
    @Mock
    private Program program_2;

    @Test
    public void findProgramsConnectedTo() {
        when(program_0.connectsTo(0)).thenReturn(true);
        when(program_1.connectsTo(0)).thenReturn(false);
        when(program_2.connectsTo(0)).thenReturn(true);

        List<Program> actual = new ProgramResolver(asList(program_0, program_1, program_2)).findProgramsConnectedTo(0);

        assertThat(actual).containsOnly(program_0, program_2);
    }

    @Test
    public void findNumberOfGroups() {
        when(program_0.getId()).thenReturn(0);
        when(program_1.getId()).thenReturn(1);
        when(program_0.connectsTo(0)).thenReturn(true);
        when(program_1.connectsTo(0)).thenReturn(false);
        when(program_1.connectsTo(1)).thenReturn(true);
        when(program_2.connectsTo(0)).thenReturn(true);

        assertThat(new ProgramResolver(asList(program_0, program_1, program_2)).findNumberOfGroups()).isEqualTo(2);
    }
}