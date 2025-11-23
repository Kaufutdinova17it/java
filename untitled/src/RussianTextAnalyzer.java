import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class RussianTextAnalyzer {
    private static final Set<Character> VOICED_CONSONANTS = Set.of(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
    );

    public static Set<Character> findVoicedConsonantsInMultipleWords(String filename) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(filename))).toLowerCase();
        String[] words = text.split("[^а-яё]+");

        Map<Character, Integer> consonantCount = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            Set<Character> consonantsInWord = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (VOICED_CONSONANTS.contains(c)) {
                    consonantsInWord.add(c);
                }
            }

            for (char consonant : consonantsInWord) {
                consonantCount.put(consonant, consonantCount.getOrDefault(consonant, 0) + 1);
            }
        }

        return consonantCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}