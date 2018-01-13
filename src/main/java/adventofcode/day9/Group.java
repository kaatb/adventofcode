package adventofcode.day9;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class Group {

    private List<Group> groups = newArrayList();
    private List<Garbage> garbage = newArrayList();

    public List<Group> getGroups() {
        return groups;
    }

    public List<Garbage> getGarbage() {
        return garbage;
    }

    private void addGroup(Group group) {
        this.groups.add(group);
    }

    private void addGarbage(Garbage garbage) {
        this.garbage.add(garbage);
    }

    public int getScore(int startingPoint) {
        int score = startingPoint + 1;
        score += groups.stream()
                .mapToInt(group -> group.getScore(startingPoint + 1))
                .sum();
        return score;
    }

    public int getNonCanceledCharactersCount() {
        int score = 0;
        score += groups.stream()
                .mapToInt(Group::getNonCanceledCharactersCount)
                .sum();
        score += garbage.stream()
                .mapToInt(Garbage::getNonCanceledCharacters)
                .sum();
        return score;
    }

    static class GroupBuilder {

        private Group group;

        private GroupBuilder() {
            this.group = new Group();
        }

        public static GroupBuilder aGroup() {
            return new GroupBuilder();
        }

        public Group build() {
            return this.group;
        }

        GroupBuilder withGroup(Group group) {
            this.group.addGroup(group);
            return this;
        }

        GroupBuilder withGarbage(Garbage garbage) {
            this.group.addGarbage(garbage);
            return this;
        }
    }
}
