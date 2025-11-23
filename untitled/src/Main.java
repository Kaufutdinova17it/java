import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Готовые тестовые файлы
    private static final String APPLICANTS_FILE = "applicants.txt";
    private static final String TEXT_FILE = "text.txt";
    private static final String PEOPLE_FILE = "people.txt";

    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ВСЕХ ЗАДАНИЙ ===");
        System.out.println("Используются готовые тестовые файлы:");
        System.out.println("- " + APPLICANTS_FILE + " (абитуриенты)");
        System.out.println("- " + TEXT_FILE + " (текст для анализа)");
        System.out.println("- " + PEOPLE_FILE + " (люди для группировки)");

        // Проверяем существование файлов
        checkRequiredFiles();

        while (true) {
            try {
                printMenu();
                int choice = readInt("Выберите задание (1-7) или 0 для выхода: ", 0, 7);

                if (choice == 0) {
                    System.out.println("Выход из программы.");
                    break;
                }

                switch (choice) {
                    case 1 -> demonstrateFraction();
                    case 2 -> demonstrateCat();
                    case 3 -> demonstrateListOperations();
                    case 4 -> demonstrateApplicants();
                    case 5 -> demonstrateTextAnalyzer();
                    case 6 -> demonstrateQueueOperations();
                    case 7 -> demonstrateStreamOperations();
                }

                System.out.println("\n" + "=".repeat(50) + "\n");

            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
                System.out.println("Попробуйте еще раз.\n");
            }
        }

        scanner.close();
    }

    private static void checkRequiredFiles() {
        String[] requiredFiles = {APPLICANTS_FILE, TEXT_FILE, PEOPLE_FILE};
        boolean allFilesExist = true;

        System.out.println("\nПроверка файлов...");
        for (String filename : requiredFiles) {
            if (Files.exists(Paths.get(filename))) {
                System.out.println(" " + filename + " - найден");
            } else {
                System.out.println(" " + filename + " - не найден");
                allFilesExist = false;
            }
        }

        if (!allFilesExist) {
            System.out.println("\n  Для полной работы программы создайте следующие файлы:");
            System.out.println("\n" + APPLICANTS_FILE + " (формат):");
            System.out.println("5");
            System.out.println("Ветров Роман 68 59");
            System.out.println("Анисимова Екатерина 64 88");
            System.out.println("Петров Иван 25 45");
            System.out.println("Сидорова Мария 35 28");
            System.out.println("Козлов Алексей 40 50");

            System.out.println("\n" + TEXT_FILE + " (формат):");
            System.out.println("бобр бегал быстро по берегу большой реки.");
            System.out.println("вдруг он увидел волка и быстро убежал в нору.");

            System.out.println("\n" + PEOPLE_FILE + " (формат):");
            System.out.println("Вася:5");
            System.out.println("Петя:3");
            System.out.println("Аня:5");
            System.out.println("Маша:");
            System.out.println("Коля:3");
            System.out.println("оля:7");
        }
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("\nМЕНЮ:");
        System.out.println("1. Дробь с кэшированием");
        System.out.println("2. Кот с подсчетом мяуканий");
        System.out.println("3. Симметрическая разность списков");
        System.out.println("4. Абитуриенты (из файла " + APPLICANTS_FILE + ")");
        System.out.println("5. Звонкие согласные (из файла " + TEXT_FILE + ")");
        System.out.println("6. Очередь в обратном порядке");
        System.out.println("7. Обработка стримами (из файла " + PEOPLE_FILE + ")");
        System.out.println("0. Выход");
    }

    // ========== ЗАДАНИЕ 1: ДРОБЬ С КЭШИРОВАНИЕМ ==========
    private static void demonstrateFraction() {
        System.out.println("\n=== ЗАДАНИЕ 1: ДРОБЬ С КЭШИРОВАНИЕМ ===");

        try {
            System.out.println("Создание дроби:");
            int numerator = readInt("Введите числитель: ");
            int denominator = readInt("Введите знаменатель: ");

            Fraction fraction = new Fraction(numerator, denominator);
            System.out.println(" Создана дробь: " + fraction);

            while (true) {
                System.out.println("\nОперации с дробью:");
                System.out.println("1. Получить десятичное значение");
                System.out.println("2. Изменить числитель");
                System.out.println("3. Изменить знаменатель");
                System.out.println("4. Сравнить с другой дробью");
                System.out.println("5. Вернуться в меню");

                int choice = readInt("Выберите операцию: ", 1, 5);

                switch (choice) {
                    case 1 -> {
                        double value = fraction.getDecimalValue();
                        System.out.println(" Десятичное значение: " + value);
                        System.out.println(" Десятичное значение (из кэша): " + fraction.getDecimalValue());
                    }
                    case 2 -> {
                        int newNumerator = readInt("Введите новый числитель: ");
                        fraction.setNumerator(newNumerator);
                        System.out.println(" Числитель изменен. Дробь: " + fraction);
                    }
                    case 3 -> {
                        int newDenominator = readInt("Введите новый знаменатель: ");
                        fraction.setDenominator(newDenominator);
                        System.out.println(" Знаменатель изменен. Дробь: " + fraction);
                    }
                    case 4 -> {
                        System.out.println("Создание дроби для сравнения:");
                        int num2 = readInt("Введите числитель второй дроби: ");
                        int den2 = readInt("Введите знаменатель второй дроби: ");
                        Fraction fraction2 = new Fraction(num2, den2);
                        System.out.println("Вторая дробь: " + fraction2);
                        System.out.println("Дроби равны: " + fraction.equals(fraction2));
                    }
                    case 5 -> { return; }
                }
            }

        } catch (IllegalArgumentException e) {
            System.err.println(" Ошибка создания дроби: " + e.getMessage());
        }
    }

    // ========== ЗАДАНИЕ 2: КОТ С ПОДСЧЕТОМ МЯУКАНИЙ ==========
    private static void demonstrateCat() {
        System.out.println("\n=== ЗАДАНИЕ 2: КОТ С ПОДСЧЕТОМ МЯУКАНИЙ ===");

        String name = readString("Введите имя кота: ", 1, 20);
        Cat cat = new Cat(name);
        CountingCatProxy countingCat = new CountingCatProxy(cat);

        System.out.println(" Создан кот: " + cat);

        int meowCount = readInt("Сколько раз кот должен мяукнуть? ", 1, 10);

        List<Meowable> meowables = new ArrayList<>();
        for (int i = 0; i < meowCount; i++) {
            meowables.add(countingCat);
        }

        System.out.println("\n Начинаем мяуканье:");
        MeowingUtils.makeAllMeow(meowables);
        System.out.println(" Кот мяукал " + countingCat.getMeowCount() + " раз");
    }

    // ========== ЗАДАНИЕ 3: СИММЕТРИЧЕСКАЯ РАЗНОСТЬ СПИСКОВ ==========
    private static void demonstrateListOperations() {
        System.out.println("\n=== ЗАДАНИЕ 3: СИММЕТРИЧЕСКАЯ РАЗНОСТЬ СПИСКОВ ===");

        // Демонстрация с заранее заданными списками
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        System.out.println(" L1: " + list1);
        System.out.println(" L2: " + list2);

        List<Integer> diff = ListOperations.symmetricDifference(list1, list2);
        System.out.println(" Симметрическая разность: " + diff);

        // Демонстрация со строками
        System.out.println("\n--- Пример со строками ---");
        List<String> strList1 = Arrays.asList("apple", "banana", "orange", "grape");
        List<String> strList2 = Arrays.asList("banana", "kiwi", "grape", "mango");
        List<String> strDiff = ListOperations.symmetricDifference(strList1, strList2);

        System.out.println(" Список 1: " + strList1);
        System.out.println(" Список 2: " + strList2);
        System.out.println(" Симметрическая разность: " + strDiff);
    }

    // ========== ЗАДАНИЕ 4: АБИТУРИЕНТЫ ИЗ ФАЙЛА ==========
    private static void demonstrateApplicants() {
        System.out.println("\n=== ЗАДАНИЕ 4: АБИТУРИЕНТЫ (из файла " + APPLICANTS_FILE + ") ===");

        try {
            if (!Files.exists(Paths.get(APPLICANTS_FILE))) {
                System.err.println(" Файл " + APPLICANTS_FILE + " не найден!");
                System.out.println("Создайте файл со следующими данными:");
                System.out.println("5");
                System.out.println("Ветров Роман 68 59");
                System.out.println("Анисимова Екатерина 64 88");
                System.out.println("Петров Иван 25 45");
                System.out.println("Сидорова Мария 35 28");
                System.out.println("Козлов Алексей 40 50");
                return;
            }

            System.out.println(" Чтение данных из файла: " + APPLICANTS_FILE);
            List<Applicant> applicants = ApplicantProcessor.readApplicantsFromFile(APPLICANTS_FILE);
            List<Applicant> failedApplicants = ApplicantProcessor.getFailedApplicants(applicants);

            System.out.println("\n Результаты обработки:");
            System.out.println("Всего абитуриентов: " + applicants.size());
            System.out.println(" Допущены к экзаменам: " + (applicants.size() - failedApplicants.size()));
            System.out.println(" Не допущены к экзаменам: " + failedApplicants.size());

            if (failedApplicants.isEmpty()) {
                System.out.println(" Все абитуриенты допущены к экзаменам!");
            } else {
                System.out.println("\n Список не допущенных абитуриентов:");
                System.out.println("Фамилия       Имя           Балл1  Балл2  Статус");
                System.out.println("-".repeat(50));
                for (Applicant applicant : failedApplicants) {
                    String status = applicant.getScore1() < 30 && applicant.getScore2() < 30 ?
                            "Оба < 30" : applicant.getScore1() < 30 ? "Предмет 1 < 30" : "Предмет 2 < 30";
                    System.out.printf("%-12s %-12s %6d %6d  %s\n",
                            applicant.getLastName(),
                            applicant.getFirstName(),
                            applicant.getScore1(),
                            applicant.getScore2(),
                            status);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println(" Ошибка обработки файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(" Ошибка в данных: " + e.getMessage());
        }
    }

    // ========== ЗАДАНИЕ 5: ЗВОНКИЕ СОГЛАСНЫЕ ==========
    private static void demonstrateTextAnalyzer() {
        System.out.println("\n=== ЗАДАНИЕ 5: ЗВОНКИЕ СОГЛАСНЫЕ (из файла " + TEXT_FILE + ") ===");

        try {
            if (!Files.exists(Paths.get(TEXT_FILE))) {
                System.err.println(" Файл " + TEXT_FILE + " не найден!");
                System.out.println("Создайте файл с русским текстом для анализа.");
                return;
            }

            System.out.println(" Анализ текста из файла: " + TEXT_FILE);
            Set<Character> consonants = RussianTextAnalyzer.findVoicedConsonantsInMultipleWords(TEXT_FILE);

            System.out.println(" Результаты анализа:");
            if (consonants.isEmpty()) {
                System.out.println(" В тексте не найдено звонких согласных, входящих в более чем одно слово");
            } else {
                System.out.println(" Звонкие согласные в более чем одном слове: " + consonants);
                System.out.println(" Всего найдено: " + consonants.size() + " согласных");

                System.out.println("\n Список согласных в алфавитном порядке:");
                List<Character> sortedConsonants = new ArrayList<>(consonants);
                Collections.sort(sortedConsonants);
                for (char c : sortedConsonants) {
                    System.out.println(" - '" + c + "'");
                }
            }

        } catch (IOException e) {
            System.err.println(" Ошибка обработки файла: " + e.getMessage());
        }
    }

    // ========== ЗАДАНИЕ 6: ОЧЕРЕДЬ В ОБРАТНОМ ПОРЯДКЕ ==========
    private static void demonstrateQueueOperations() {
        System.out.println("\n=== ЗАДАНИЕ 6: ОЧЕРЕДЬ В ОБРАТНОМ ПОРЯДКЕ ===");

        // Демонстрация с заранее заданной очередью
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println(" Исходная очередь: " + queue);
        QueueOperations.printQueueReverse(queue);

        // Демонстрация со строками
        System.out.println("\n--- Пример со строками ---");
        Queue<String> stringQueue = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(" Исходная очередь строк: " + stringQueue);
        QueueOperations.printQueueReverse(stringQueue);
    }

    // ========== ЗАДАНИЕ 7: ОБРАБОТКА СТРИМАМИ ==========
    private static void demonstrateStreamOperations() {
        System.out.println("\n=== ЗАДАНИЕ 7: ОБРАБОТКА СТРИМАМИ ===");

        System.out.println("1. Обработка точек и создание ломаной");
        System.out.println("2. Обработка людей из файла " + PEOPLE_FILE);

        int choice = readInt("Выберите подзадание: ", 1, 2);

        try {
            switch (choice) {
                case 1 -> processPoints();
                case 2 -> processPeople();
            }
        } catch (IOException e) {
            System.err.println(" Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Ошибка: " + e.getMessage());
        }
    }

    private static void processPoints() {
        System.out.println("\n--- ОБРАБОТКА ТОЧЕК И СОЗДАНИЕ ЛОМАНОЙ ---");

        // Демонстрация с заранее заданными точками
        List<Point> points = Arrays.asList(
                new Point(1, 2), new Point(3, -4), new Point(1, 2),
                new Point(5, 6), new Point(0, -1), new Point(3, 4),
                new Point(-2, -3), new Point(7, 8)
        );

        System.out.println(" Исходные точки: " + points);
        System.out.println(" Обработка стримом:");
        System.out.println("   - Удаление дубликатов");
        System.out.println("   - Сортировка по X");
        System.out.println("   - Преобразование отрицательных Y в положительные");

        Polyline polyline = StreamOperations.processPoints(points);
        System.out.println(" Результирующая ломаная: " + polyline);
    }

    private static void processPeople() throws IOException {
        System.out.println("\n--- ОБРАБОТКА ЛЮДЕЙ ИЗ ФАЙЛА " + PEOPLE_FILE + " ---");

        if (!Files.exists(Paths.get(PEOPLE_FILE))) {
            System.err.println(" Файл " + PEOPLE_FILE + " не найден!");
            System.out.println("Создайте файл со следующими данными:");
            System.out.println("Вася:5");
            System.out.println("Петя:3");
            System.out.println("Аня:5");
            System.out.println("Маша:");
            System.out.println("Коля:3");
            System.out.println("оля:7");
            return;
        }

        System.out.println(" Содержимое файла:");
        Files.lines(Paths.get(PEOPLE_FILE)).forEach(System.out::println);

        System.out.println("\n Обработка стримом:");
        System.out.println("   - Чтение из файла");
        System.out.println("   - Приведение имен к формату с заглавной буквой");
        System.out.println("   - Фильтрация людей без номеров");
        System.out.println("   - Группировка по номерам");

        Map<Integer, List<String>> groupedPeople = StreamOperations.processPeopleFromFile(PEOPLE_FILE);

        System.out.println("\n Сгруппированные люди:");
        if (groupedPeople.isEmpty()) {
            System.out.println(" Нет данных для отображения");
        } else {
            groupedPeople.forEach((number, names) ->
                    System.out.println( + number + ": " + names));
        }
    }

    // ========== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ДЛЯ ВВОДА ==========

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println(" Ошибка: введите целое число");
            }
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.err.println(" Ошибка: число должно быть в диапазоне от " + min + " до " + max);
        }
    }

    private static String readString(String prompt, int minLength, int maxLength) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.length() < minLength) {
                System.err.println(" Ошибка: строка должна содержать не менее " + minLength + " символов");
                continue;
            }

            if (input.length() > maxLength) {
                System.err.println(" Ошибка: строка должна содержать не более " + maxLength + " символов");
                continue;
            }

            return input;
        }
    }
}