package adventofcode.day15;

public class Runner {

    public static void main(String[] args) {
        Judge judge = new Judge(new Generator(16807L, 4L, 618L),
                new Generator(48271L, 8L, 814L));
        for (int i = 0; i < 40000000; i++) {
            judge.check();
        }
        System.out.println(judge.getNumberOfMatches());


        Judge judge2 = new Judge(new Generator(16807L, 4L, 618L),
                new Generator(48271L, 8L, 814L));
        for (int i = 0; i < 5000000; i++) {
            judge2.checkWithRequirement();
        }
        System.out.println(judge2.getNumberOfMatches());
    }
}
