package adventofcode.day15;

import org.apache.commons.lang3.StringUtils;

class Judge {

    private int numberOfMatches = 0;
    private Generator generatorA;
    private Generator generatorB;

    public Judge(Generator generatorA, Generator generatorB) {
        this.generatorA = generatorA;
        this.generatorB = generatorB;
    }

    public void check() {
        check(generatorA.nextValue(), generatorB.nextValue());
    }

    public void checkWithRequirement() {
        check(generatorA.generateNextValueMeetingRequirement(), generatorB.generateNextValueMeetingRequirement());
    }

    private void check(Long generatedByA, Long generatedByB) {
        String binaryA = Long.toBinaryString(generatedByA);
        String binaryB = Long.toBinaryString(generatedByB);

        String binaryAToCompare = StringUtils.substring(binaryA, binaryA.length() - 16);
        String binaryBToCompare = StringUtils.substring(binaryB, binaryB.length() - 16);
        if (binaryAToCompare.equals(binaryBToCompare)) {
            numberOfMatches++;
        }
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }
}
