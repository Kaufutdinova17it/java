import java.util.Scanner;
public class Check {
    public static int validateIntInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, попробуйте еще раз.");
                scanner.next();
            }
        }
    }

    public static String validateStringInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println("Некорректный ввод.Пожалуйста, введите непустую строку.");
            }
        }
    }
}