package adventofcode.day16;

import java.util.List;

public interface DanceMove {

    int perform(Program program, List<Program> programs);

    void reset();
}
