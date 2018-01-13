package adventofcode.day9;

import adventofcode.day9.Group.GroupBuilder;
import org.apache.commons.lang3.StringUtils;

import static adventofcode.day9.Group.GroupBuilder.aGroup;

class StreamWithGarbageParser {

    private static final char GROUP_SEPARATOR_CHAR = ',';
    private static final char GARBAGE_START_CHAR = '<';
    private static final char GROUP_START_CHAR = '{';
    private static final char GROUP_END_CHAR = '}';
    private static final char CANCEL_NEXT_CHARACTER_CHAR = '!';
    private static final char GARBAGE_END_CHAR = '>';

    private static final String GROUP_SEPARATOR = "" + GROUP_SEPARATOR_CHAR;
    private static final String GARBAGE_START = "" + GARBAGE_START_CHAR;
    private static final String EMPTY_GROUP = "{}";
    private static final String GROUP_START = "" + GROUP_START_CHAR;

    public Group parseStream(String input) {
        return getGroups(input.substring(1, input.length() - 1), aGroup());
    }

    private Group getGroups(String input, GroupBuilder groupBuilder) {
        while (input.length() != 0) {
            if (input.startsWith(EMPTY_GROUP)) {
                input = addEmptyGroup(input, groupBuilder);
            } else if (input.startsWith(GROUP_SEPARATOR)) {
                input = remove(input, GROUP_SEPARATOR);
            } else if (input.startsWith(GARBAGE_START)) {
                input = addGarbage(input, groupBuilder);
            } else if (input.startsWith(GROUP_START)) {
                input = createAndAddNewGroup(input, groupBuilder);
            }

        }
        return groupBuilder.build();
    }

    private String createAndAddNewGroup(String input, GroupBuilder groupBuilder) {
        String subInput = getSubInput(input);
        groupBuilder.withGroup(getGroups(subInput, GroupBuilder.aGroup()));
        input = remove(input, subInput);
        input = remove(input, EMPTY_GROUP);
        return input;
    }

    private String addGarbage(String input, GroupBuilder groupBuilder) {
        String completeGarbageString = findCompleteGarbageString(input);
        groupBuilder.
                withGarbage(new Garbage(completeGarbageString));
        input = remove(input, completeGarbageString);
        return input;
    }

    private String addEmptyGroup(String input, GroupBuilder groupBuilder) {
        groupBuilder.withGroup(aGroup().build());
        input = remove(input, EMPTY_GROUP);
        return input;
    }

    private String remove(String input, String toRemove) {
        return StringUtils.replaceOnce(input, toRemove, "");
    }

    private String findCompleteGarbageString(String input) {
        char[] inputChars = input.toCharArray();
        StringBuilder garbageString = new StringBuilder()
                .append(inputChars[0]);

        int i = 1;
        char previousChar = inputChars[i - 1];
        char currentChar = inputChars[i];
        garbageString.append(currentChar);
        i++;
        while (!(previousChar != CANCEL_NEXT_CHARACTER_CHAR && currentChar == GARBAGE_END_CHAR)) {
            previousChar = currentChar;
            currentChar = inputChars[i];
            garbageString.append(currentChar);
            i++;
            if (currentChar == CANCEL_NEXT_CHARACTER_CHAR && previousChar == CANCEL_NEXT_CHARACTER_CHAR) {
                previousChar = '*';
                currentChar = inputChars[i];
                garbageString.append(currentChar);
                i++;
            }
        }
        return garbageString.toString();
    }

    private String getSubInput(String input) {
        StringBuilder subinput = new StringBuilder();
        int openBrackets = 1;
        input = remove(input, GROUP_START);
        while (input.length() > 0) {
            if (input.charAt(0) == GARBAGE_START_CHAR) {
                String garbageString = findCompleteGarbageString(input);
                subinput.append(garbageString);
                input = remove(input, garbageString);
            } else {
                if (input.charAt(0) == GROUP_START_CHAR) {
                    openBrackets++;
                } else if (input.charAt(0) == GROUP_END_CHAR) {
                    openBrackets--;
                }
                if (openBrackets == 0) {
                    return subinput.toString();
                } else {
                    subinput.append(input.charAt(0));
                    input = remove(input, "" + input.charAt(0));
                }
            }
        }
        return subinput.toString();
    }
}
