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
        System.out.println(" ДЕМОНСТРАЦИЯ ВСЕХ ЗАДАНИЙ ");

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

    private static void printMenu() {
        System.out.println("\nМЕНЮ:");
        System.out.println("1. Дробь с кэшированием");
        System.out.println("2. Кот с подсчетом мяуканий");
        System.out.println("3. Симметрическая разность списков");
        System.out.println("4. Абитуриенты (из файла " + APPLICANTS_FILE + ")");
        System.out.println("5. Звонкие согласные (из файла " + TEXT_FILE + ")");
        System.out.println("6. Очередь в обратном порядке");
        System.out.println("7. Обработка стримами");
        System.out.println("0. Выход");
    }

    // ЗАДАНИЕ 1: ДРОБЬ С КЭШИРОВАНИЕМ
    private static void demonstrateFraction() {
        System.out.println("\n=== ЗАДАНИЕ 1: ДРОБЬ С КЭШИРОВАНИЕМ ===");

        try {
            System.out.println("Создание дроби:");
            int numerator = readInt("Введите числитель: ");
            int denominator = readInt("Введите знаменатель (не 0): ");

            // Проверка знаменателя
            if (denominator == 0) {
                throw new IllegalArgumentException("Знаменатель не может быть равен 0");
            }

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

                        if (den2 == 0) {
                            System.err.println("Ошибка: знаменатель не может быть 0");
                            continue;
                        }

                        Fraction fraction2 = new Fraction(num2, den2);
                        System.out.println("Вторая дробь: " + fraction2);
                        System.out.println("Дроби равны: " + fraction.equals(fraction2));
                    }
                    case 5 -> { return; }
                }
            }

        } catch (IllegalArgumentException e) {
            System.err.println(" Ошибка: " + e.getMessage());
        }
    }

    //  ЗАДАНИЕ 2: КОТ С ПОДСЧЕТОМ МЯУКАНИЙ
    private static void demonstrateCat() {
        System.out.println("\n ЗАДАНИЕ 2: КОТ С ПОДСЧЕТОМ МЯУКАНИЙ ");

        String name = readString("Введите имя кота (1-20 символов): ", 1, 20);
        Cat cat = new Cat(name);
        CountingCatProxy countingCat = new CountingCatProxy(cat);

        System.out.println(" Создан кот: " + cat);

        int meowCount = readInt("Сколько раз кот должен мяукнуть? (1-10): ", 1, 10);

        List<Meowable> meowables = new ArrayList<>();
        for (int i = 0; i < meowCount; i++) {
            meowables.add(countingCat);
        }

        System.out.println("\n Начинаем мяуканье:");
        MeowingUtils.makeAllMeow(meowables);
        System.out.println(" Кот мяукал " + countingCat.getMeowCount() + " раз");
    }

    // ЗАДАНИЕ 3: СИММЕТРИЧЕСКАЯ РАЗНОСТЬ СПИСКОВ
    private static void demonstrateListOperations() {
        System.out.println("\n ЗАДАНИЕ 3: СИММЕТРИЧЕСКАЯ РАЗНОСТЬ СПИСКОВ ");

        System.out.println("Выберите тип данных:");
        System.out.println("1. Числа");
        System.out.println("2. Строки");

        int typeChoice = readInt("Выберите (1-2): ", 1, 2);

        if (typeChoice == 1) {
            demonstrateNumbersList();
        } else {
            demonstrateStringsList();
        }
    }

    private static void demonstrateNumbersList() {
        System.out.println("\n--- Работа с числами ---");

        List<Integer> list1 = readIntList("Введите элементы первого списка (через пробел): ");
        List<Integer> list2 = readIntList("Введите элементы второго списка (через пробел): ");

        System.out.println(" L1: " + list1);
        System.out.println(" L2: " + list2);

        List<Integer> diff = ListOperations.symmetricDifference(list1, list2);
        System.out.println(" Симметрическая разность: " + diff);
    }

    private static void demonstrateStringsList() {
        System.out.println("\n--- Работа со строками ---");

        List<String> list1 = readStringList("Введите элементы первого списка (через пробел): ");
        List<String> list2 = readStringList("Введите элементы второго списка (через пробел): ");

        System.out.println(" Список 1: " + list1);
        System.out.println(" Список 2: " + list2);

        List<String> diff = ListOperations.symmetricDifference(list1, list2);
        System.out.println(" Симметрическая разность: " + diff);
    }

    // ========== ЗАДАНИЕ 4: АБИТУРИЕНТЫ ИЗ ФАЙЛА ==========
    private static void demonstrateApplicants() {
        System.out.println("\n=== ЗАДАНИЕ 4: АБИТУРИЕНТЫ (из файла " + APPLICANTS_FILE + ") ===");

        try {
            // Проверка существования файла
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

    // ЗАДАНИЕ 5: ЗВОНКИЕ СОГЛАСНЫЕ
    private static void demonstrateTextAnalyzer() {
        System.out.println("\n ЗАДАНИЕ 5: ЗВОНКИЕ СОГЛАСНЫЕ (из файла " + TEXT_FILE + ")");

        try {
            // Проверка существования файла
            if (!Files.exists(Paths.get(TEXT_FILE))) {
                System.err.println(" Файл " + TEXT_FILE + " не найден!");
                System.out.println("Создайте файл с русским текстом для анализа.");
                return;
            }

            System.out.println(" Анализ текста из файла: " + TEXT_FILE);
            Set<Character> consonants = RussianTextAnalyzer.findVoicedConsonantsInMultipleWords(TEXT_FILE);

            System.out.println("\n Результаты анализа:");
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
        System.out.println("\nЗАДАНИЕ 6: ОЧЕРЕДЬ В ОБРАТНОМ ПОРЯДКЕ");

        System.out.println("Введите элементы очереди (через пробел):");
        String input;

        // Читаем ввод до получения непустой строки
        while (true) {
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.err.println("Ошибка: ввод не может быть пустым. Попробуйте снова:");
        }

        String[] parts = input.split("\\s+");
        Queue<String> queue = new LinkedList<>(Arrays.asList(parts));

        System.out.println(" Исходная очередь: " + queue);
        QueueOperations.printQueueReverse(queue);
    }

    // ========== ЗАДАНИЕ 7: ОБРАБОТКА СТРИМАМИ ==========
    private static void demonstrateStreamOperations() {
        System.out.println("\n ЗАДАНИЕ 7: ОБРАБОТКА СТРИМАМИ ");

        System.out.println("1. Обработка точек и создание ломаной");
        System.out.println("2. Обработка людей из файла " + PEOPLE_FILE);

        int choice = readInt("Выберите подзадание: ", 1, 2);

        // Добавляем очистку буфера после readInt
        scanner.nextLine();

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

        System.out.println("Введите точки в формате: x1 y1 x2 y2 ...");
        System.out.println("Пример: 1 2 3 4 -1 5");

        String input;

        // Читаем ввод до получения непустой строки
        while (true) {
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.err.println("Ошибка: ввод не может быть пустым. Попробуйте снова:");
        }

        String[] coords = input.split("\\s+");

        if (coords.length % 2 != 0) {
            System.err.println("Ошибка: должно быть четное количество чисел (x y)");
            return;
        }

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < coords.length; i += 2) {
            try {
                int x = Integer.parseInt(coords[i]);
                int y = Integer.parseInt(coords[i + 1]);
                points.add(new Point(x, y));
            } catch (NumberFormatException e) {
                System.err.println("Пропущены нечисловые значения: " + coords[i] + " " + coords[i + 1]);
            }
        }

        if (points.isEmpty()) {
            System.out.println("Нет корректных точек для обработки");
            return;
        }

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
            return;
        }

        System.out.println(" Содержимое файла:");
        Files.lines(Paths.get(PEOPLE_FILE)).forEach(System.out::println);

        System.out.println("\n Обработка стримом:");
        System.out.println("   - Приведение имен к формату с заглавной буквой");
        System.out.println("   - Фильтрация людей без номеров");
        System.out.println("   - Группировка по номерам");

        Map<Integer, List<String>> groupedPeople = StreamOperations.processPeopleFromFile(PEOPLE_FILE);

        System.out.println("\n Сгруппированные люди:");
        if (groupedPeople.isEmpty()) {
            System.out.println(" Нет данных для отображения");
        } else {
            groupedPeople.forEach((number, names) ->
                    System.out.println(" " + number + ": " + names));
        }
    }

    // ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ДЛЯ ВВОДА

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

    private static List<Integer> readIntList(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return new ArrayList<>();
            }

            String[] parts = input.split("\\s+");
            List<Integer> list = new ArrayList<>();
            boolean hasError = false;

            for (String part : parts) {
                try {
                    list.add(Integer.parseInt(part));
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка: '" + part + "' не является целым числом");
                    hasError = true;
                }
            }

            if (!hasError) {
                return list;
            }

            System.err.println("Попробуйте ввести список снова.");
        }
    }

    private static List<String> readStringList(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays.asList(input.split("\\s+"));
    }
}