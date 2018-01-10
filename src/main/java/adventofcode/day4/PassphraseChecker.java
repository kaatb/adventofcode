package adventofcode.day4;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

class PassphraseChecker {

    private static final String PASSPHRASE_WORD_DIVIDER = " ";

    public boolean isValid(String passphrase) {
        List<String> distinctValues = splitPhraseToWords(passphrase)
                .stream()
                .distinct()
                .collect(Collectors.toList());

        return splitPhraseToWords(passphrase)
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

    private List<String> splitPhraseToWords(String passphrase) {
        return stream(passphrase.split(PASSPHRASE_WORD_DIVIDER))
                .collect(Collectors.toList());
    }
}
