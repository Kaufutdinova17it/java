import java.io.*;
import java.nio.file.*;
import java.util.*;

public class RussianTextAnalyzer {
    // Все звонкие согласные русского языка
    private static final Set<Character> VOICED_CONSONANTS = Set.of(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
    );


    public static Set<Character> findVoicedConsonantsInMultipleWords(String filename) throws IOException {

        // 1. ЧИТАЕМ ВЕСЬ ТЕКСТ ИЗ ФАЙЛА
        // Преобразуем путь к файлу в объект Path
        Path filePath = Paths.get(filename);
        // Читаем все байты из файла
        byte[] fileContent = Files.readAllBytes(filePath);
        // Преобразуем байты в строку
        String fullText = new String(fileContent);
        // Приводим все буквы к маленьким (чтобы "Б" и "б" считались одинаково)
        String lowerText = fullText.toLowerCase();

        // 2. ДЕЛИМ ТЕКСТ НА СЛОВА
        // Разбиваем текст по всему, что НЕ русская буква
        String[] words = lowerText.split("[^а-яё]+");

        // 3. ПОДСЧИТЫВАЕМ СОГЛАСНЫЕ
        // Будем хранить: буква → сколько слов содержат эту букву
        Map<Character, Integer> consonantCounter = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            // Находим уникальные согласные в этом слове
            Set<Character> consonantsInThisWord = new HashSet<>();

            // Проверяем каждую букву слова
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);

                // Если это звонкий согласный
                if (VOICED_CONSONANTS.contains(letter)) {
                    // Добавляем в множество для этого слова
                    // HashSet автоматически убирает повторы
                    consonantsInThisWord.add(letter);
                }
            }

            // Увеличиваем счетчики для всех согласных этого слова
            for (char consonant : consonantsInThisWord) {
                // Получаем текущее значение счетчика
                // Если согласного еще нет в карте, используем 0
                int currentCount = consonantCounter.getOrDefault(consonant, 0);
                // Увеличиваем счетчик на 1
                consonantCounter.put(consonant, currentCount + 1);
            }
        }

        // 4. ВЫБИРАЕМ ТОЛЬКО ТЕ СОГЛАСНЫЕ, КОТОРЫЕ В НЕСКОЛЬКИХ СЛОВАХ
        // TreeSet автоматически сортирует буквы по алфавиту
        Set<Character> result = new TreeSet<>();

        // Смотрим все пары "буква-счетчик"
        for (Map.Entry<Character, Integer> entry : consonantCounter.entrySet()) {
            char consonant = entry.getKey();
            int howManyWords = entry.getValue();

            // Если буква есть в более чем одном слове
            if (howManyWords > 1) {
                result.add(consonant);
            }
        }


        return result;
    }
}