package adventofcode.day9;

class Garbage {

    private final String garbage;

    Garbage(String garbage) {
        this.garbage = garbage;
    }

    public String getGarbage() {
        return garbage;
    }

    public int getNonCanceledCharacters() {
        int count = 0;
        char[] chars = garbage.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '!') {
                i++;
            } else {
                count++;
            }
        }
        return count;
    }
}
