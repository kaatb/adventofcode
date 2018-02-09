package adventofcode.day15;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {

    @Test
    public void nextValue_GeneratorA() {
        Generator generatorA = new Generator(16807L, 4L, 65L);
        generatorA.nextValue();
        generatorA.nextValue();
        generatorA.nextValue();
        generatorA.nextValue();
        generatorA.nextValue();

        assertThat(generatorA.getValues()).containsExactly(65L, 1092455L, 1181022009L, 245556042L, 1744312007L, 1352636452L);
    }

    @Test
    public void nextValue_GeneratorB() {
        Generator generatorB = new Generator(48271L, 8L, 8921L);
        generatorB.nextValue();
        generatorB.nextValue();
        generatorB.nextValue();
        generatorB.nextValue();
        generatorB.nextValue();

        assertThat(generatorB.getValues()).containsExactly(8921L, 430625591L, 1233683848L, 1431495498L, 137874439L, 285222916L);
    }

    @Test
    public void nextValueMeetingRequirement_GeneratorA() {
        Generator generatorA = new Generator(16807L, 4L, 65L);
        assertThat(generatorA.generateNextValueMeetingRequirement()).isEqualTo(1352636452L);
        assertThat(generatorA.generateNextValueMeetingRequirement()).isEqualTo(1992081072L);
        assertThat(generatorA.generateNextValueMeetingRequirement()).isEqualTo(530830436L);
        assertThat(generatorA.generateNextValueMeetingRequirement()).isEqualTo(1980017072L);
        assertThat(generatorA.generateNextValueMeetingRequirement()).isEqualTo(740335192L);
    }

    @Test
    public void nextValueMeetingRequirement_GeneratorB() {
        Generator generatorB = new Generator(48271L, 8L, 8921L);
        assertThat(generatorB.generateNextValueMeetingRequirement()).isEqualTo(1233683848L);
        assertThat(generatorB.generateNextValueMeetingRequirement()).isEqualTo(862516352L);
        assertThat(generatorB.generateNextValueMeetingRequirement()).isEqualTo(1159784568L);
        assertThat(generatorB.generateNextValueMeetingRequirement()).isEqualTo(1616057672L);
        assertThat(generatorB.generateNextValueMeetingRequirement()).isEqualTo(412269392L);
    }
}