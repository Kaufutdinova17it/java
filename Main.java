import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Задание 1.1 - Обобщенная коробка
            demonstrateBox(scanner);

            // Задание 1.2 - Хранилище без null
            demonstrateStorage(scanner);

            System.out.println("\nЗАДАНИЕ 3: ОБОБЩЕННЫЕ МЕТОДЫ \n");

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
        System.out.println("1. ДЕМОНСТРАЦИЯ КОРОБКИ ");

        Box<Integer> intBox = new Box<>();
        System.out.println("Создана пустая коробка: " + intBox);

        // Ввод первого числа
        int number = readIntInput(scanner, "Введите целое число для помещения в коробку: ");

        try {
            intBox.put(number);
            System.out.println("Положили число в коробку: " + intBox);

            // Пробуем положить второе число в заполненную коробку
            System.out.println("\nПопробуем положить еще одно число в заполненную коробку:");
            int anotherNumber = readIntInput(scanner, "Введите еще одно число: ");
            intBox.put(anotherNumber);

        } catch (IllegalStateException e) {
            System.out.println("Ошибка (ожидаемо): " + e.getMessage());
            System.out.println("Коробка осталась неизменной: " + intBox);
        }

        // Извлекаем значение
        if (!intBox.isEmpty()) {
            Integer value = intBox.get();
            System.out.println("Извлекли значение из коробки: " + value);
            System.out.println("Коробка после извлечения: " + intBox);
        }

        System.out.println();
    }

    private static void demonstrateStorage(Scanner scanner) {
        System.out.println("2. ДЕМОНСТРАЦИЯ ХРАНИЛИЩА");

        System.out.println("\n2.1 Хранилище чисел с null:");
        Storage<Integer> nullIntStorage = new Storage<>(null, 0);
        System.out.println("Создано хранилище: " + nullIntStorage);
        System.out.println("Извлекли значение: " + nullIntStorage.get());

        System.out.println("\n2.2 Хранилище чисел со значением:");
        Integer number = readIntInput(scanner, "Введите число для хранилища: ");
        Storage<Integer> intStorage = new Storage<>(number, -1);
        System.out.println("Создано хранилище: " + intStorage);
        System.out.println("Извлекли значение: " + intStorage.get());

        System.out.println("\n2.3 Хранилище строк с null:");
        Storage<String> nullStringStorage = new Storage<>(null, "default");
        System.out.println("Создано хранилище: " + nullStringStorage);
        System.out.println("Извлекли значение: " + nullStringStorage.get());

        System.out.println("\n2.4 Хранилище строк со значением:");
        System.out.print("Введите строку для хранилища: ");
        String inputString = scanner.nextLine();
        Storage<String> stringStorage = new Storage<>(inputString, "hello world" + inputString);
        System.out.println("Создано хранилище: " + stringStorage);
        System.out.println("Извлекли значение: " + stringStorage.get());

        System.out.println();
    }

    private static void demonstrateMapFunction(Scanner scanner) {
        System.out.println("3.1 ФУНКЦИЯ (MAP)");

        // 1. Строки в длины строк
        System.out.println("\n3.1.1 Преобразование строк в их длины");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        List<Integer> lengths = GenericUtils.map(strings1, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        System.out.println("Строки: " + strings1 + " -> Длины: " + lengths);

        // 2. Числа в абсолютные значения
        System.out.println("\n3.1.2 Преобразование чисел в абсолютные значения");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        List<Integer> absoluteValues = GenericUtils.map(numbers, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return Math.abs(n);
            }
        });
        System.out.println("Числа: " + numbers + " -> Абсолютные значения: " + absoluteValues);

        // 3. Массивы в максимальные значения
        System.out.println("\n3.1.3 Преобразование массивов в их максимальные значения");
        System.out.println("Введите массивы целых чисел (пример: '1 2 3, -5 0 5, 10 20 30 40')");
        System.out.println("Формат: числа внутри массива через пробел, массивы через запятую");
        List<int[]> arrays = readArrayList(scanner, "Введите массивы: ");

        List<Integer> maxValues = GenericUtils.map(arrays, new Function<int[], Integer>() {
            @Override
            public Integer apply(int[] arr) {
                return Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
            }
        });
        System.out.println("Массивы: " + arraysToString(arrays) + " -> Максимальные значения: " + maxValues);

        System.out.println();
    }

    private static void demonstrateFilter(Scanner scanner) {
        System.out.println("3.2 ФИЛЬТР");

        // 1. Фильтрация строк по длине >= 3
        System.out.println("\n3.2.1 Фильтрация строк по длине >= 3");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        List<String> longStrings = GenericUtils.filter(strings1, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() >= 3;
            }
        });
        System.out.println("Строки: " + strings1 + " -> Длина >= 3: " + longStrings);

        // 2. Фильтрация положительных чисел
        System.out.println("\n3.2.2 Фильтрация положительных чисел");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        List<Integer> positiveNumbers = GenericUtils.filter(numbers, new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n > 0;
            }
        });
        System.out.println("Числа: " + numbers + " -> Положительные: " + positiveNumbers);

        // 3. Фильтрация массивов без положительных элементов
        System.out.println("\n3.2.3 Фильтрация массивов без положительных элементов");
        System.out.println("Введите массивы целых чисел (пример: '-1 -2 -3, -5 0 -1, 1 -2 3, -10 -20')");
        System.out.println("Формат: числа внутри массива через пробел, массивы через запятую");
        List<int[]> arrays = readArrayList(scanner, "Введите массивы: ");

        List<int[]> arraysWithoutPositive = GenericUtils.filter(arrays, new Predicate<int[]>() {
            @Override
            public boolean test(int[] arr) {
                return Arrays.stream(arr).allMatch(n -> n <= 0);
            }
        });
        System.out.println("Массивы: " + arraysToString(arrays) + " -> Без положительных элементов: " + arraysToString(arraysWithoutPositive));

        System.out.println();
    }

    private static void demonstrateReduce(Scanner scanner) {
        System.out.println("3.3 СОКРАЩЕНИЕ");

        // 1. Конкатенация строк
        System.out.println("\n3.3.1 Конкатенация строк");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        String concatenated = GenericUtils.reduce(strings1, new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1 + s2;
            }
        }, "");
        System.out.println("Строки: " + strings1 + " -> Конкатенация: " + concatenated);

        // 2. Сумма чисел
        System.out.println("\n3.3.2 Сумма чисел");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        Integer sum = GenericUtils.reduce(numbers, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 + n2;
            }
        }, 0);
        System.out.println("Числа: " + numbers + " -> Сумма: " + sum);

        // 3. Подсчет общего количества элементов во вложенных списках
        System.out.println("\n3.3.3 Подсчет элементов во вложенных списках");
        System.out.println("Введите вложенные списки целых чисел (пример: '1 2 3; 4 5; 6 7 8 9')");
        System.out.println("Формат: числа внутри списка через пробел, списки через точку с запятой");

        List<List<Integer>> nestedLists = readNestedList(scanner, "Введите вложенные списки: ");

        // Способ 1: Создаем специальный класс для подсчета
        class Counter {
            int count = 0;
        }

        Counter counter = new Counter();
        //для каждого элемента в nestedLists
        for (List<Integer> list : nestedLists) {
            counter.count += list.size();
        }

        System.out.println("Вложенные списки: " + nestedLists + " -> Общее количество элементов: " + counter.count);

        // Способ 2: Используем reduce с общим списком
        System.out.println("\nАльтернативный способ через объединение списков");
        List<Integer> allElements = new ArrayList<>();
        for (List<Integer> list : nestedLists) {
            allElements = GenericUtils.reduce(
                    Arrays.asList(allElements, list),
                    new BinaryOperator<List<Integer>>() {
                        @Override
                        public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
                            List<Integer> result = new ArrayList<>(list1);
                            result.addAll(list2);
                            return result;
                        }
                    },
                    new ArrayList<>()
            );
        }
        System.out.println("Вложенные списки: " + nestedLists + " -> Все элементы: " + allElements + " -> Количество: " + allElements.size());

        System.out.println();
    }

    private static void demonstrateCollect(Scanner scanner) {
        System.out.println("3.4 КОЛЛЕКЦИОНИРОВАНИЕ");

        // 1. Разделение на положительные и отрицательные числа
        System.out.println("\n3.4.1 Разделение чисел на положительные и отрицательные");
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
        System.out.println("\n3.4.2 Группировка строк по длине");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        Map<Integer, List<String>> lengthGroups = GenericUtils.collect(
                strings1,
                // создаем пустую Hashmap для результатов
                HashMap::new,
                (map, str) -> {
                    int length = str.length();
                    map.computeIfAbsent(length, k -> new ArrayList<>()).add(str);
                }
        );
        System.out.println("Строки: " + strings1 + " -> Группы по длине: " + lengthGroups);

        // 3. Создание набора без дубликатов
        System.out.println("\n3.4.3 Создание набора без дубликатов");
        List<String> stringsWithDuplicates = readStringList(scanner, "Введите строки через запятую (будут удалены дубликаты): ");

        Set<String> uniqueSet = GenericUtils.collect(
                stringsWithDuplicates,
                // Создаем пустой HashSet (автоматически удаляет дубликаты)
                HashSet::new,
                // Добавляем элементы в Set
                (set, str) -> set.add(str)
        );
        System.out.println("Строки с дубликатами: " + stringsWithDuplicates + " -> Уникальный набор: " + uniqueSet);

        System.out.println();
    }

    //  ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ

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

    private static List<int[]> readArrayList(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Ошибка: ввод не может быть пустым!");
                    continue;
                }

                String[] arrayStrings = input.split(",");
                List<int[]> result = new ArrayList<>();

                for (String arrayStr : arrayStrings) {
                    String[] numberStrings = arrayStr.trim().split("\\s+");
                    int[] array = new int[numberStrings.length];

                    for (int i = 0; i < numberStrings.length; i++) {
                        array[i] = Integer.parseInt(numberStrings[i].trim());
                    }

                    result.add(array);
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректные целые числа!");
                System.out.println("Формат: числа через пробел внутри массива, массивы через запятую");
                System.out.println("Пример: '1 2 3, -5 0 5, 10 20 30 40'");
            }
        }
    }

    private static List<List<Integer>> readNestedList(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Ошибка: ввод не может быть пустым!");
                    continue;
                }

                String[] listStrings = input.split(";");
                List<List<Integer>> result = new ArrayList<>();

                for (String listStr : listStrings) {
                    List<Integer> innerList = new ArrayList<>();
                    String[] numberStrings = listStr.trim().split("\\s+");

                    for (String numStr : numberStrings) {
                        if (!numStr.trim().isEmpty()) {
                            innerList.add(Integer.parseInt(numStr.trim()));
                        }
                    }

                    result.add(innerList);
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректные целые числа!");
                System.out.println("Формат: числа через пробел внутри списка, списки через точку с запятой");
                System.out.println("Пример: '1 2 3; 4 5; 6 7 8 9'");
            }
        }
    }

    private static String arraysToString(List<int[]> arrays) {
        return arrays.stream()
                .map(arr -> Arrays.toString(arr))
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
