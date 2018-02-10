package adventofcode.day16;

import java.util.List;

public class Exchange implements DanceMove {

    private final int personA;
    private final int personB;

    public Exchange(int personA, int personB) {
        this.personA = personA;
        this.personB = personB;
    }

    @Override
    public void reset() {
    }

    @Override
    public int perform(Program program, List<Program> programs) {
        if (program.getPlace() == personA) {
            return personB;
        } else if (program.getPlace() == personB) {
            return personA;
        } else {
            return program.getPlace();
        }
    }

    int getPersonA() {
        return personA;
    }

    int getPersonB() {
        return personB;
    }
}
