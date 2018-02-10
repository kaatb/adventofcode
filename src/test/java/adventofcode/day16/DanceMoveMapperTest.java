package adventofcode.day16;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DanceMoveMapperTest {

    @Test
    public void map_spin() {
        DanceMove actual = new DanceMoveMapper().map("s3");
        assertThat(actual).isInstanceOf(Spin.class);
        assertThat(((Spin) actual).getNewFrontOfLine()).isEqualTo(3);
    }

    @Test
    public void map_exchange() {
        DanceMove actual = new DanceMoveMapper().map("x2/45");
        assertThat(actual).isInstanceOf(Exchange.class);
        assertThat(((Exchange) actual).getPersonA()).isEqualTo(2);
        assertThat(((Exchange) actual).getPersonB()).isEqualTo(45);
    }

    @Test
    public void map_partner() {
        DanceMove actual = new DanceMoveMapper().map("pf/k");
        assertThat(actual).isInstanceOf(Partner.class);
        assertThat(((Partner) actual).getPersonA()).isEqualTo("f");
        assertThat(((Partner) actual).getPersonB()).isEqualTo("k");
    }
}