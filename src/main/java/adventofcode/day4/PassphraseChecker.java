package adventofcode.day4;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

class PassphraseChecker {

    private static final String PASSPHRASE_WORD_DIVIDER = " ";

    public boolean isValid(String passphrase) {
        List<List<Character>> distinctValues = getDistinctWords(passphrase);

        return splitPhraseToWordsWithSortedLetters(passphrase)
                .stream()
                .noneMatch(a -> {
                    if (distinctValues.contains(a)) {
                        distinctValues.remove(a);
                        return false;
                    } else {
                        return true;
                    }
                });
    }

    private List<List<Character>> getDistinctWords(String passphrase) {
        return splitPhraseToWordsWithSortedLetters(passphrase)
                .stream()
                .distinct()
                .collect(toList());
    }

    private List<List<Character>> splitPhraseToWordsWithSortedLetters(String passphrase) {
        return stream(passphrase.split(PASSPHRASE_WORD_DIVIDER))
                .map(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .sorted()
                        .collect(toList()))
                .collect(toList());
    }
}
