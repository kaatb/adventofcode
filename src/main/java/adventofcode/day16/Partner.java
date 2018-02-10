package adventofcode.day16;

import java.util.List;

public class Partner implements DanceMove {

    private final String personA;
    private final String personB;
    private Integer placeA;
    private Integer placeB;

    public Partner(String personA, String personB) {
        this.personA = personA;
        this.personB = personB;
    }

    @Override
    public void reset() {
        placeA = null;
        placeB = null;
    }

    @Override
    public int perform(Program program, List<Program> programs) {
        determinePlaces(programs);
        if (program.getName().equals(personA)) {
            return placeB;
        } else if (program.getName().equals(personB)) {
            return placeA;
        } else {
            return program.getPlace();
        }
    }

    private void determinePlaces(List<Program> programs) {
        if (placeA == null) {
            placeA = programs.stream().filter(p -> p.getName().equals(personA)).findFirst().get().getPlace();
            placeB = programs.stream().filter(p -> p.getName().equals(personB)).findFirst().get().getPlace();
        }
    }

    String getPersonA() {
        return personA;
    }

    String getPersonB() {
        return personB;
    }
}
