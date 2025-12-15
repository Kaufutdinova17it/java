import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class StreamOperations {
    public static Polyline processPoints(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("Список точек не может быть пустым");
        }

        List<Point> result = points.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .collect(Collectors.toList());

        return new Polyline(result);
    }

    public static Map<Integer, List<String>> processPeopleFromFile(String filename) throws IOException {
        if (!Files.exists(Paths.get(filename))) {
            throw new FileNotFoundException("Файл не найден: " + filename);
        }

        return Files.lines(Paths.get(filename))
                .map(line -> line.split(":"))
                .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty())
                .map(parts -> {
                    try {
                        return new String[]{
                                parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase(),
                                parts[1].trim()
                        };
                    } catch (StringIndexOutOfBoundsException e) {
                        System.err.println("Пропущена строка с неверным форматом имени: " + Arrays.toString(parts));
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        parts -> {
                            try {
                                return Integer.parseInt(parts[1]);
                            } catch (NumberFormatException e) {
                                System.err.println("Пропущена строка с неверным номером: " + Arrays.toString(parts));
                                return -1;
                            }
                        },
                        Collectors.mapping(parts -> parts[0], Collectors.toList())
                ))
                .entrySet().stream()
                .filter(entry -> entry.getKey() != -1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}