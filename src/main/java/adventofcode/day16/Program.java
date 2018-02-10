package adventofcode.day16;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class Program {

    private final String name;
    private int intialPlace;
    private int place;

    public Program(String name, int place) {
        this.name = name;
        this.intialPlace = place;
        this.place = place;
    }

    public void doMove(DanceMove dancemove, List<Program> programs) {
        this.place = dancemove.perform(this, programs);
    }

    public int getPlace() {
        return place;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getInitialPlace() {
        return intialPlace;
    }
}
