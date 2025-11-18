
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ ВСЕХ КЛАССОВ И МЕТОДОВ ===\n");

            // Задание 1.1 - Обобщенная коробка
            demonstrateBox(scanner);

            // Задание 1.2 - Хранилище без null
            demonstrateStorage(scanner);

            // Задание 3.1 - Функция (map)
            demonstrateMapFunction(scanner);

            // Задание 3.2 - Фильтр
            demonstrateFilter(scanner);

            // Задание 3.3 - Сокращение (reduce)
            demonstrateReduce(scanner);

            // Задание 3.4 - Коллекционирование
            demonstrateCollect(scanner);

        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
            System.out.println("\nПрограмма завершена.");
        }
    }

    private static void demonstrateBox(Scanner scanner) {
        System.out.println("1. ДЕМОНСТРАЦИЯ КОРОБКИ:");

        Box<Integer> intBox = new Box<>();
        System.out.println("Создана пустая коробка: " + intBox);

        // Ввод первого числа
        int number = readIntInput(scanner, "Введите целое число для помещения в коробку (для задания можно ввести число 3): ");

        try {
            intBox.put(number);
            System.out.println("Положили число в коробку: " + intBox);
            // Теперь пробуем положить ВТОРОЕ число в ЗАПОЛНЕННУЮ коробку
            System.out.println("\nПопробуйте положить еще одно число в ЗАПОЛНЕННУЮ коробку:");
            int anotherNumber = readIntInput(scanner, "Введите еще одно число: ");

            intBox.put(anotherNumber);

        } catch (IllegalStateException e) {
            System.out.println("Ошибка (ожидаемо): " + e.getMessage());
            System.out.println("Коробка осталась неизменной: " + intBox);
        }

        System.out.println();
    }
    private static void processBox(Box<Integer> box) {
        if (!box.isEmpty()) {
            Integer value = box.get();
            System.out.println("Извлекли значение из коробки: " + value);
            System.out.println("Коробка после извлечения: " + box);
        }
    }

    private static void demonstrateStorage(Scanner scanner) {
        System.out.println("2. ДЕМОНСТРАЦИЯ ХРАНИЛИЩА:");

        System.out.println("\n2.1 Хранилище чисел с null:");
        Storage<Integer> nullIntStorage = new Storage<>(null, 0);
        System.out.println("Создано хранилище: " + nullIntStorage);
        processStorage(nullIntStorage);

        System.out.println("\n2.2 Хранилище чисел со значением:");
        Integer number = readIntInput(scanner, "Введите число для хранилища (для задания можно ввести число 99): ");
        Storage<Integer> intStorage = new Storage<>(number, -1);
        System.out.println("Создано хранилище: " + intStorage);
        processStorage(intStorage);

        System.out.println("\n2.3 Хранилище строк с null:");
        Storage<String> nullStringStorage = new Storage<>(null, "default");
        System.out.println("Создано хранилище: " + nullStringStorage);
        processStorage(nullStringStorage);

        System.out.println("\n2.4 Хранилище строк со значением:");
        System.out.print("Введите строку для хранилища (для задания можно ввести hello): ");
        String inputString = scanner.nextLine();
        Storage<String> stringStorage = new Storage<>(inputString, inputString + "hello world");
        System.out.println("Создано хранилище: " + stringStorage);
        processStorage(stringStorage);

        System.out.println();
    }

    private static <T> void processStorage(Storage<T> storage) {
        T value = storage.get();
        System.out.println("Извлекли значение из хранилища: " + value);
    }

    private static void demonstrateMapFunction(Scanner scanner) {
        System.out.println("3.1 ДЕМОНСТРАЦИЯ ФУНКЦИИ (MAP):");

        // 1. Строки -> длины строк
        System.out.println("\n3.1.1 Преобразование строк в их длины:");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую (для задания можно использовать qwerty,asdfg,zx): ");
        List<Integer> lengths = GenericUtils.map(strings1, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        System.out.println("Строки: " + strings1 + " -> Длины: " + lengths);

        // 2. Числа -> абсолютные значения
        System.out.println("\n3.1.2 Преобразование чисел в абсолютные значения:");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        List<Integer> absoluteValues = GenericUtils.map(numbers, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return Math.abs(n);
            }
        });
        System.out.println("Числа: " + numbers + " -> Абсолютные значения: " + absoluteValues);

        System.out.println();
    }

    private static void demonstrateFilter(Scanner scanner) {
        System.out.println("3.2 ДЕМОНСТРАЦИЯ ФИЛЬТРА:");

        // 1. Фильтрация строк по длине >= 3
        System.out.println("\n3.2.1 Фильтрация строк по длине >= 3:");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        List<String> longStrings = GenericUtils.filter(strings1, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() >= 3;
            }
        });
        System.out.println("Строки: " + strings1 + " -> Длина >= 3: " + longStrings);

        // 2. Фильтрация положительных чисел
        System.out.println("\n3.2.2 Фильтрация положительных чисел:");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        List<Integer> positiveNumbers = GenericUtils.filter(numbers, new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n > 0;
            }
        });
        System.out.println("Числа: " + numbers + " -> Положительные: " + positiveNumbers);

        System.out.println();
    }

    private static void demonstrateReduce(Scanner scanner) {
        System.out.println("3.3 ДЕМОНСТРАЦИЯ СОКРАЩЕНИЯ (REDUCE):");

        // 1. Конкатенация строк
        System.out.println("\n3.3.1 Конкатенация строк:");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        String concatenated = GenericUtils.reduce(strings1, new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1 + s2;
            }
        }, "");
        System.out.println("Строки: " + strings1 + " -> Конкатенация: " + concatenated);

        // 2. Сумма чисел
        System.out.println("\n3.3.2 Сумма чисел:");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        Integer sum = GenericUtils.reduce(numbers, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 + n2;
            }
        }, 0);
        System.out.println("Числа: " + numbers + " -> Сумма: " + sum);

        System.out.println();
    }

    private static void demonstrateCollect(Scanner scanner) {
        System.out.println("3.4 ДЕМОНСТРАЦИЯ КОЛЛЕКЦИОНИРОВАНИЯ:");

        // 1. Разделение на положительные и отрицательные числа
        System.out.println("\n3.4.1 Разделение чисел на положительные и отрицательные:");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        Map<String, List<Integer>> numberGroups = GenericUtils.collect(
                numbers,
                () -> {
                    Map<String, List<Integer>> map = new HashMap<>();
                    map.put("positive", new ArrayList<>());
                    map.put("negative", new ArrayList<>());
                    map.put("zero", new ArrayList<>());
                    return map;
                },
                (map, number) -> {
                    if (number > 0) {
                        map.get("positive").add(number);
                    } else if (number < 0) {
                        map.get("negative").add(number);
                    } else {
                        map.get("zero").add(number);
                    }
                }
        );
        System.out.println("Числа: " + numbers + " -> Группы: " + numberGroups);

        // 2. Группировка строк по длине
        System.out.println("\n3.4.2 Группировка строк по длине:");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        Map<Integer, List<String>> lengthGroups = GenericUtils.collect(
                strings1,
                HashMap::new,
                (map, str) -> {
                    int length = str.length();
                    map.computeIfAbsent(length, k -> new ArrayList<>()).add(str);
                }
        );
        System.out.println("Строки: " + strings1 + " -> Группы по длине: " + lengthGroups);

        System.out.println();
    }

    // Вспомогательный метод для безопасного ввода целых чисел
    private static int readIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число!");
            }
        }
    }

    // Вспомогательный метод для ввода списка целых чисел
    private static List<Integer> readIntList(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Ошибка: ввод не может быть пустым!");
                    continue;
                }

                String[] parts = input.split(",");
                List<Integer> result = new ArrayList<>();
                for (String part : parts) {
                    result.add(Integer.parseInt(part.trim()));
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите числа через запятую (например: 1, -3, 7)!");
            }
        }
    }

    // Вспомогательный метод для ввода списка строк
    private static List<String> readStringList(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Ошибка: ввод не может быть пустым!");
                continue;
            }

            String[] parts = input.split(",");
            List<String> result = new ArrayList<>();
            for (String part : parts) {
                result.add(part.trim());
            }
            return result;
        }
    }
}