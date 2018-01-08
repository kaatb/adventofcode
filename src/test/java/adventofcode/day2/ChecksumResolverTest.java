package adventofcode.day2;

import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class ChecksumResolverTest {

    @Test
    public void resolve() throws Exception {
        assertThat(new ChecksumResolver().resolve(newArrayList("5\t1\t9\t5", "7\t5\t3", "2\t4\t6\t8"))).isEqualTo(18);
    }
}