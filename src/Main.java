import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            demonstrateBox(scanner);
            demonstrateStorage(scanner);
            demonstrateBoxWithPoint(scanner);
            System.out.println("\nЗАДАНИЕ 3: ОБОБЩЕННЫЕ МЕТОДЫ \n");

            demonstrateMapFunction(scanner);
            demonstrateFilter(scanner);
            demonstrateReduce(scanner);
            demonstrateCollect(scanner);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nПрограмма завершена.");
        }
    }

    private static void demonstrateBox(Scanner scanner) {
        System.out.println("1. ДЕМОНСТРАЦИЯ КОРОБКИ ");
        Box<Integer> intBox = new Box<>();
        System.out.println("Создана пустая коробка: " + intBox);

        int number = readIntInput(scanner, "Введите целое число для помещения в коробку: ");
        try {
            intBox.put(number);
            System.out.println("Положили число в коробку: " + intBox);

            int anotherNumber = readIntInput(scanner, "Введите еще одно число: ");
            intBox.put(anotherNumber);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка (ожидаемо): " + e.getMessage());
            System.out.println("Коробка осталась неизменной: " + intBox);
        }

        if (!intBox.isEmpty()) {
            Integer value = intBox.get();
            System.out.println("Извлекли значение: " + value);
            System.out.println("Коробка после извлечения: " + intBox);
        }
        System.out.println();
    }

    private static void demonstrateStorage(Scanner scanner) {
        System.out.println("2. ДЕМОНСТРАЦИЯ ХРАНИЛИЩА");

        System.out.println("\n2.1 Хранилище чисел с null:");
        Storage<Integer> nullIntStorage = new Storage<>(null, 0);
        System.out.println("Создано: " + nullIntStorage);
        System.out.println("Извлекли: " + nullIntStorage.get());

        System.out.println("\n2.2 Хранилище чисел со значением:");
        Integer number = readIntInput(scanner, "Введите число для хранилища: ");
        Storage<Integer> intStorage = new Storage<>(number, -1);
        System.out.println("Создано: " + intStorage);
        System.out.println("Извлекли: " + intStorage.get());

        System.out.println("\n2.3 Хранилище строк с null:");
        Storage<String> nullStringStorage = new Storage<>(null, "default");
        System.out.println("Создано: " + nullStringStorage);
        System.out.println("Извлекли: " + nullStringStorage.get());

        System.out.println("\n2.4 Хранилище строк со значением:");
        System.out.print("Введите строку для хранилища: ");
        String inputString = scanner.nextLine();
        Storage<String> stringStorage = new Storage<>(inputString, "hello world");
        System.out.println("Создано: " + stringStorage);
        System.out.println("Извлекли: " + stringStorage.get());

        System.out.println();
    }

    //задание 1.3
    private static void demonstrateBoxWithPoint(Scanner scanner) {
        System.out.println("1.3 КОРОБКА С ТРЕХМЕРНОЙ ТОЧКОЙ");

        // Создаем коробку для точек
        Box<Point3D> pointBox = new Box<>();
        System.out.println("Создана пустая коробка для трехмерных точек");

        // Вводим координаты точки
        System.out.println("Введите координаты трехмерной точки:");
        double x = readDoubleInput(scanner, "  x = ");
        double y = readDoubleInput(scanner, "  y = ");
        double z = readDoubleInput(scanner, "  z = ");

        // Создаем точку и кладем в коробку
        Point3D point = new Point3D(x, y, z);

        // Демонстрация работы обобщенного метода с разными типами
        System.out.println("\n--- Демонстрация работы с разными типами коробок ---");

        // 1. Кладем точку в коробку для точек
        putInBox(pointBox, point);
        System.out.println("Точка помещена в коробку для точек: " + pointBox);

        // 2. Кладем строку в коробку для строк (демонстрация работы с другим типом)
        Box<String> stringBox = new Box<>();
        putInBox(stringBox, "Произвольная строка");
        System.out.println("Строка помещена в коробку для строк: " + stringBox);

        // 3. Кладем число в коробку для чисел
        Box<Integer> intBox = new Box<>();
        putInBox(intBox, 42);
        System.out.println("Число помещено в коробку для чисел: " + intBox);

        // Извлекаем точку из коробки
        System.out.println("\n--- Извлечение точки ---");
        if (!pointBox.isEmpty()) {
            Point3D extractedPoint = pointBox.get();
            System.out.println("Извлекли точку из коробки: " + extractedPoint);
            System.out.println("Координаты: x=" + extractedPoint.getX() +
                    ", y=" + extractedPoint.getY() +
                    ", z=" + extractedPoint.getZ());
            System.out.println("Коробка после извлечения: " + pointBox);
        }

        System.out.println();
    }

    // НОВЫЙ ОБОБЩЕННЫЙ МЕТОД: кладет любой объект в коробку
    public static <T> void putInBox(Box<T> box, T item) {
        try {
            box.put(item);
            System.out.println("✓ Объект успешно помещен в коробку");
        } catch (IllegalStateException e) {
            System.out.println("✗ Не удалось поместить объект: " + e.getMessage());
        }
    }

    private static void demonstrateMapFunction(Scanner scanner) {
        System.out.println("3.1 ФУНКЦИЯ (MAP)");

        System.out.println("\n3.1.1 Строки в длины строк");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        List<Integer> lengths = GenericUtils.map(strings1, s -> s.length());
        System.out.println("Строки: " + strings1 + " -> Длины: " + lengths);

        System.out.println("\n3.1.2 Числа в абсолютные значения");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        List<Integer> absoluteValues = GenericUtils.map(numbers, Math::abs);
        System.out.println("Числа: " + numbers + " -> Абсолютные значения: " + absoluteValues);

        System.out.println("\n3.1.3 Массивы в максимальные значения");
        System.out.println("Введите массивы целых чисел (пример: '1 2 3, -5 0 5, 10 20 30 40')");
        List<int[]> arrays = readArrayList(scanner, "Введите массивы: ");
        List<Integer> maxValues = GenericUtils.map(arrays, arr -> Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));
        System.out.println("Массивы: " + arraysToString(arrays) + " -> Максимальные значения: " + maxValues);

        System.out.println();
    }

    private static void demonstrateFilter(Scanner scanner) {
        System.out.println("3.2 ФИЛЬТР");

        System.out.println("\n3.2.1 Фильтрация строк по длине >= 3");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        List<String> longStrings = GenericUtils.filter(strings1, s -> s.length() >= 3);
        System.out.println("Строки: " + strings1 + " -> Длина >= 3: " + longStrings);

        System.out.println("\n3.2.2 Фильтрация положительных чисел");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        List<Integer> positiveNumbers = GenericUtils.filter(numbers, n -> n > 0);
        System.out.println("Числа: " + numbers + " -> Положительные: " + positiveNumbers);

        System.out.println("\n3.2.3 Фильтрация массивов без положительных элементов");
        System.out.println("Введите массивы целых чисел (пример: '-1 -2 -3, -5 0 -1, 1 -2 3, -10 -20')");
        List<int[]> arrays = readArrayList(scanner, "Введите массивы: ");
        List<int[]> arraysWithoutPositive = GenericUtils.filter(arrays, arr -> Arrays.stream(arr).allMatch(n -> n <= 0));
        System.out.println("Массивы: " + arraysToString(arrays) + " -> Без положительных элементов: " + arraysToString(arraysWithoutPositive));

        System.out.println();
    }

    private static void demonstrateReduce(Scanner scanner) {
        System.out.println("3.3 СОКРАЩЕНИЕ");

        System.out.println("\n3.3.1 Конкатенация строк");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        String concatenated = GenericUtils.reduce(strings1, (s1, s2) -> s1 + s2, "");
        System.out.println("Строки: " + strings1 + " -> Конкатенация: " + concatenated);

        System.out.println("\n3.3.2 Сумма чисел");
        List<Integer> numbers = readIntList(scanner, "Введите числа через запятую: ");
        Integer sum = GenericUtils.reduce(numbers, (n1, n2) -> n1 + n2, 0);
        System.out.println("Числа: " + numbers + " -> Сумма: " + sum);

        System.out.println("\n3.3.3 Подсчет элементов во вложенных списках");
        System.out.println("Введите вложенные списки (пример: '1 2 3; 4 5; 6 7 8 9')");
        List<List<Integer>> nestedLists = readNestedList(scanner, "Введите вложенные списки: ");
        int totalCount = nestedLists.stream().mapToInt(List::size).sum();
        System.out.println("Вложенные списки: " + nestedLists + " -> Общее количество элементов: " + totalCount);

        System.out.println();
    }

    private static void demonstrateCollect(Scanner scanner) {
        System.out.println("3.4 КОЛЛЕКЦИОНИРОВАНИЕ");

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
                    if (number > 0) map.get("positive").add(number);
                    else if (number < 0) map.get("negative").add(number);
                    else map.get("zero").add(number);
                }
        );
        System.out.println("Числа: " + numbers + " -> Группы: " + numberGroups);

        System.out.println("\n3.4.2 Группировка строк по длине");
        List<String> strings1 = readStringList(scanner, "Введите строки через запятую: ");
        Map<Integer, List<String>> lengthGroups = GenericUtils.collect(
                strings1,
                HashMap::new,
                (map, str) -> map.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str)
        );
        System.out.println("Строки: " + strings1 + " -> Группы по длине: " + lengthGroups);

        System.out.println("\n3.4.3 Создание набора без дубликатов");
        List<String> stringsWithDuplicates = readStringList(scanner, "Введите строки через запятую (будут удалены дубликаты): ");
        Set<String> uniqueSet = GenericUtils.collect(
                stringsWithDuplicates,
                HashSet::new,
                Set::add
        );
        System.out.println("Строки с дубликатами: " + stringsWithDuplicates + " -> Уникальный набор: " + uniqueSet);

        System.out.println();
    }

    // Вспомогательные методы
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

    // НОВЫЙ метод для чтения double
    private static double readDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число!");
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
                return Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите числа через запятую!");
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
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
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
                return Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(s -> Arrays.stream(s.split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray())
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: проверьте формат ввода!");
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
                return Arrays.stream(input.split(";"))
                        .map(String::trim)
                        .map(s -> Arrays.stream(s.split("\\s+"))
                                .filter(str -> !str.isEmpty())
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: проверьте формат ввода!");
            }
        }
    }

    private static String arraysToString(List<int[]> arrays) {
        return arrays.stream()
                .map(Arrays::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}