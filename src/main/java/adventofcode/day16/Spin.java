package adventofcode.day16;

import java.util.List;

public class Spin implements DanceMove {

    private int newFrontOfLine;

    public Spin(int newFrontOfLine) {
        this.newFrontOfLine = newFrontOfLine;
    }

    @Override
    public void reset() {
    }

    @Override
    public int perform(Program program, List<Program> programs) {
        if (program.getPlace() >= programs.size() - getNewFrontOfLine()) {
            return program.getPlace() - programs.size() + getNewFrontOfLine();
        } else {
            return program.getPlace() + getNewFrontOfLine();
        }
    }

    public int getNewFrontOfLine() {
        return newFrontOfLine;
    }
}
