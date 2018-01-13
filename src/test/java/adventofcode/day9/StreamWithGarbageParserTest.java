package adventofcode.day9;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamWithGarbageParserTest {

    private StreamWithGarbageParser streamParser;

    @Before
    public void setUp() {
        streamParser = new StreamWithGarbageParser();
    }

    @Test
    public void parseStream_EmptyGroup() {
        Group actual = streamParser.parseStream("{}");
        assertThat(actual).isNotNull();
        assertThat(actual.getGroups()).hasSize(0);
    }

    @Test
    public void parseStream_NestedGroup() {
        Group actual = streamParser.parseStream("{{{}}}");
        assertThat(actual.getGroups()).hasSize(1);
        assertThat(actual.getGroups().get(0).getGroups()).hasSize(1);
        assertThat(actual.getGroups().get(0).getGroups().get(0).getGroups()).hasSize(0);
    }

    @Test
    public void parseStream_ListOfGroups() {
        Group actual = streamParser.parseStream("{{},{}}");
        assertThat(actual.getGroups()).hasSize(2);
        assertThat(actual.getGroups().get(0).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(1).getGroups()).hasSize(0);
    }

    @Test
    public void parseStream_ListOfGroupsAndNestedGroup() {
        Group actual = streamParser.parseStream("{{{},{},{{}}}}");
        assertThat(actual.getGroups()).hasSize(1);
        assertThat(actual.getGroups().get(0).getGroups()).hasSize(3);
        assertThat(actual.getGroups().get(0).getGroups().get(0).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(0).getGroups().get(1).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(0).getGroups().get(2).getGroups()).hasSize(1);
        assertThat(actual.getGroups().get(0).getGroups().get(2).getGroups().get(0).getGroups()).hasSize(0);
    }

    @Test
    public void parseStream_GroupOfGarbage() {
        Group actual = streamParser.parseStream("{<a>,<a>,<a>,<a>}");
        assertThat(actual.getGroups()).hasSize(0);
        assertThat(actual.getGarbage()).hasSize(4);
        assertThat(actual.getGarbage().get(0).getGarbage()).isEqualTo("<a>");
        assertThat(actual.getGarbage().get(1).getGarbage()).isEqualTo("<a>");
        assertThat(actual.getGarbage().get(2).getGarbage()).isEqualTo("<a>");
        assertThat(actual.getGarbage().get(3).getGarbage()).isEqualTo("<a>");
    }

    @Test
    public void parseStream_NestedGroupsWithGarbage() {
        Group actual = streamParser.parseStream("{{<ab>},{<ab>},{<ab>},{<ab>}}");
        assertThat(actual.getGroups()).hasSize(4);
        assertThat(actual.getGroups().get(0).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(0).getGarbage().get(0).getGarbage()).isEqualTo("<ab>");
        assertThat(actual.getGroups().get(1).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(1).getGarbage().get(0).getGarbage()).isEqualTo("<ab>");
        assertThat(actual.getGroups().get(2).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(2).getGarbage().get(0).getGarbage()).isEqualTo("<ab>");
        assertThat(actual.getGroups().get(3).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(3).getGarbage().get(0).getGarbage()).isEqualTo("<ab>");
    }

    @Test
    public void parseStream_ListOfGroupsWithGarbage() {
        Group actual = streamParser.parseStream("{{<!!>},{<!!>},{<!!>},{<!!>}}");
        assertThat(actual.getGroups()).hasSize(4);
        assertThat(actual.getGroups().get(0).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(0).getGarbage().get(0).getGarbage()).isEqualTo("<!!>");
        assertThat(actual.getGroups().get(1).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(1).getGarbage().get(0).getGarbage()).isEqualTo("<!!>");
        assertThat(actual.getGroups().get(2).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(2).getGarbage().get(0).getGarbage()).isEqualTo("<!!>");
        assertThat(actual.getGroups().get(3).getGroups()).hasSize(0);
        assertThat(actual.getGroups().get(3).getGarbage().get(0).getGarbage()).isEqualTo("<!!>");
    }

    @Test
    public void parseStream_ListOfEscapedGarbage() {
        Group actual = streamParser.parseStream("{{<a!>},{<a!>},{<a!>},{<ab>}}");
        assertThat(actual.getGroups()).hasSize(1);
        assertThat(actual.getGroups().get(0).getGarbage().get(0).getGarbage()).isEqualTo("<a!>},{<a!>},{<a!>},{<ab>");
    }

    @Test
    public void parseStreamAndGetScore() {
//        assertThat(streamParser.parseStream("{{{{{{<!!!>!>,<i!!'!!{>},{},{<{}}!>},<i<\"{,}{!!oo>}},{{{{<}i<}\"\">},{<o<!>>}},<!!!>uo{}!!'!!<!!!>o!>>}").getScore(0)).isEqualTo(1);
        assertThat(streamParser.parseStream("{}").getScore(0)).isEqualTo(1);
        assertThat(streamParser.parseStream("{{{}}}").getScore(0)).isEqualTo(6);
        assertThat(streamParser.parseStream("{{},{}}").getScore(0)).isEqualTo(5);
        assertThat(streamParser.parseStream("{{{},{},{{}}}}").getScore(0)).isEqualTo(16);
        assertThat(streamParser.parseStream("{<a>,<a>,<a>,<a>}").getScore(0)).isEqualTo(1);
        assertThat(streamParser.parseStream("{{<ab>},{<ab>},{<ab>},{<ab>}}").getScore(0)).isEqualTo(9);
        assertThat(streamParser.parseStream("{{<!!>},{<!!>},{<!!>},{<!!>}}").getScore(0)).isEqualTo(9);
        assertThat(streamParser.parseStream("{{<a!>},{<a!>},{<a!>},{<ab>}}").getScore(0)).isEqualTo(3);

    }
}