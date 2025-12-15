import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class ApplicantProcessor {
    public static List<Applicant> readApplicantsFromFile(String filename) throws IOException {
        List<Applicant> applicants = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));

        if (lines.isEmpty()) {
            throw new IOException("Файл пуст: " + filename);
        }

        // Чтение количества абитуриентов
        int n;
        try {
            n = Integer.parseInt(lines.get(0).trim());
        } catch (NumberFormatException e) {
            throw new IOException("Неверный формат количества абитуриентов в первой строке: " + lines.get(0));
        }

        // Проверка допустимого количества
        if (n <= 0 || n > 500) {
            throw new IOException("Количество абитуриентов должно быть от 1 до 500, получено: " + n);
        }

        // Проверка достаточности строк
        if (lines.size() < n + 1) {
            throw new IOException("Недостаточно строк в файле. Ожидается: " + (n + 1) + ", получено: " + lines.size());
        }

        // Обработка данных абитуриентов
        for (int i = 1; i <= n; i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                System.err.println("Предупреждение: пропущена пустая строка " + (i + 1));
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts.length < 4) {
                throw new IOException("Неверный формат данных в строке " + (i + 1) + ": " + line);
            }

            try {
                // Сбор данных (фамилия может состоять из нескольких слов)
                String lastName = parts[0];
                String firstName = parts[1];
                int score1 = Integer.parseInt(parts[parts.length - 2]);
                int score2 = Integer.parseInt(parts[parts.length - 1]);

                // Проверка баллов
                if (score1 < 0 || score1 > 100) {
                    throw new IOException("Балл по предмету 1 должен быть 0-100 в строке " + (i + 1) + ": " + score1);
                }
                if (score2 < 0 || score2 > 100) {
                    throw new IOException("Балл по предмету 2 должен быть 0-100 в строке " + (i + 1) + ": " + score2);
                }

                applicants.add(new Applicant(lastName, firstName, score1, score2));

            } catch (NumberFormatException e) {
                throw new IOException("Неверный формат чисел в строке " + (i + 1) + ": " + line);
            }
        }

        System.out.println("Успешно обработано абитуриентов: " + applicants.size());
        return applicants;
    }

    public static List<Applicant> getFailedApplicants(List<Applicant> applicants) {
        return applicants.stream()
                .filter(Applicant::isFailed)
                .collect(Collectors.toList());
    }

    // Дополнительный метод для получения статистики
    public static void printStatistics(List<Applicant> applicants) {
        long total = applicants.size();
        long failed = applicants.stream().filter(Applicant::isFailed).count();
        long passed = total - failed;

        System.out.println("\nСтатистика:");
        System.out.println("Всего абитуриентов: " + total);
        System.out.println("Допущены: " + passed);
        System.out.println("Не допущены: " + failed);
        System.out.printf("Процент допуска: %.1f%%\n", (double) passed / total * 100);
    }
}