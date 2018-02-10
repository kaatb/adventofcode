package adventofcode.day16;

public class DanceMoveMapper {

    public DanceMove map(String danceMove) {
        if (danceMove.startsWith("s")) {
            return new Spin(Integer.parseInt(getMoveParameters(danceMove)));
        } else if (danceMove.startsWith("x")) {
            return new Exchange(Integer.parseInt(getMoveParameter(danceMove, 0)),
                    Integer.parseInt(getMoveParameter(danceMove, 1)));
        } else if (danceMove.startsWith("p")) {
            return new Partner(getMoveParameter(danceMove, 0),
                    getMoveParameter(danceMove, 1));
        }
        throw new IllegalArgumentException("Unsupported dancemove: " + danceMove);
    }

    private String getMoveParameter(String danceMove, int index) {
        return getMoveParameters(danceMove).split("/")[index];
    }

    private String getMoveParameters(String danceMove) {
        return danceMove.substring(1);
    }
}
