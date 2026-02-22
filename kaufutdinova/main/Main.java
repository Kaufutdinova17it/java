package ru.kaufutdinova.main;

import ru.kaufutdinova.cities.*;
import ru.kaufutdinova.geometry.*;
import ru.kaufutdinova.birds.*;
import ru.kaufutdinova.utils.*;
import static ru.kaufutdinova.utils.MathUtils.power;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== ПРОГРАММА ДЕМОНСТРАЦИИ РАБОТЫ КЛАССОВ ===\n");

        demonstrateGeometryWithInput();
        demonstrateCitiesWithInput();
        demonstrateBirdsWithInput();

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ГОТОВЫХ РЕШЕНИЙ ===");
        demonstratePredefinedCities();

        if (args.length >= 2) {
            demonstratePower(args);
        }

        scanner.close();
    }

    private static void demonstrateGeometryWithInput() {
        System.out.println("--- РАБОТА С ТОЧКАМИ (введите данные) ---");

        System.out.println("Создание 2D точки:");
        ForPoint forPoint = new ForPoint();
        double x = forPoint.Coordinate("X");
        double y = forPoint.Coordinate("Y");
        Point userPoint = new Point(x, y);
        System.out.println("Создана точка: " + userPoint);

        System.out.println("\nСоздание 3D точки:");
        double x3 = forPoint.Coordinate("X");
        double y3 = forPoint.Coordinate("Y");
        double z3 = forPoint.Coordinate("Z");
        Point3D userPoint3D = new Point3D(x3, y3, z3);
        System.out.println("Создана 3D точка: " + userPoint3D);

        Point cloned = userPoint.clone();
        System.out.println("Клон точки: " + cloned);
        System.out.println("Оригинал и клон равны? " + userPoint.equals(cloned));

        Line line = new Line(userPoint, userPoint3D);
        System.out.println("Линия между точками: " + line);
        System.out.println("Длина линии: " + line.length());
        System.out.println();
    }

    /**
     * Проверка, что название города содержит только буквы
     */
    private static boolean isValidCityName(String name) {
        return name.matches("[a-zA-Zа-яА-Я]+"); // только буквы (русские и английские)
    }

    /**
     * Проверка, что стоимость положительная
     */
    private static boolean isValidCost(int cost) {
        return cost > 0;
    }

    private static void demonstrateCitiesWithInput() {
        System.out.println("--- РАБОТА С ГОРОДАМИ (введите данные) ---");

        // Ввод первого города с проверкой
        String name1;
        while (true) {
            System.out.print("Введите название первого города (только буквы): ");
            name1 = Check.validateStringInput(scanner);
            if (isValidCityName(name1)) {
                break;
            } else {
                System.out.println("Ошибка! Название должно содержать только буквы.");
            }
        }
        City city1 = new City(name1);

        // Ввод второго города с проверкой
        String name2;
        while (true) {
            System.out.print("Введите название второго города (только буквы): ");
            name2 = Check.validateStringInput(scanner);
            if (isValidCityName(name2)) {
                break;
            } else {
                System.out.println("Ошибка! Название должно содержать только буквы.");
            }
        }
        City city2 = new City(name2);

        // Ввод стоимости с проверкой на положительное число
        int cost;
        while (true) {
            System.out.print("Введите стоимость дороги из " + name1 + " в " + name2 + " (положительное число): ");
            cost = Check.validateIntInput(scanner);
            if (isValidCost(cost)) {
                break;
            } else {
                System.out.println("Ошибка! Стоимость должна быть положительным числом.");
            }
        }
        city1.addRoad(city2, cost);

        scanner.nextLine(); // Очистка буфера

        System.out.println("\nСозданы города:");
        System.out.println(city1);
        System.out.println(city2);

        Route route = new Route(city1, city2);
        System.out.println("Маршрут: " + route);
        System.out.println();
    }

    private static void demonstrateBirdsWithInput() {
        System.out.println("--- РАБОТА С ПТИЦАМИ (введите данные) ---");

        Bird sparrow = new Sparrow();
        System.out.print("Воробей поёт: ");
        sparrow.sing();

        Bird cuckoo = new Cuckoo();
        System.out.print("Кукушка поёт: ");
        cuckoo.sing();

        System.out.print("Введите текст для попугая: ");
        String parrotText = Check.validateStringInput(scanner);
        Bird parrot = new Parrot(parrotText);
        System.out.print("Попугай поёт: ");
        parrot.sing();
        System.out.println();
    }

    private static void demonstratePredefinedCities() {
        System.out.println("--- ГРАФ ИЗ ЗАДАЧИ 5.9 (ГОРОДИМ) ---");

        BidirectionalCity A = new BidirectionalCity("A");
        BidirectionalCity B = new BidirectionalCity("B");
        City C = new City("C");
        BidirectionalCity D = new BidirectionalCity("D");
        BidirectionalCity E = new BidirectionalCity("E");

        A.addRoad(B, 1);
        A.addRoad(C, 1);
        B.addOneWayRoad(C, 1);
        E.addOneWayRoad(C, 1);
        B.addRoad(D, 1);
        D.addRoad(E, 1);

        System.out.println("Граф построен:");
        City[] cities = {A, B, C, D, E};
        for (City city : cities) {
            System.out.println(city);
        }

        System.out.println("\nМАРШРУТЫ:");
        testRoute(new Route(D, A), "D → A");
        testRoute(new Route(A, E), "A → E");
        testRoute(new Route(C, D), "C → D");
        testRoute(new Route(B, E), "B → E");

        BidirectionalCity F = new BidirectionalCity("F");
        BidirectionalCity G = new BidirectionalCity("G");
        F.addRoad(G, 1);
        System.out.println("\nГорода F и G созданы с двусторонней дорогой");
        testRoute(new Route(F, D), "F → D");
    }

    private static void testRoute(Route route, String description) {
        City[] path = route.findPath();
        if (path.length > 0) {
            System.out.print(description + ": ");
            for (City city : path) {
                System.out.print(city.getName() + " ");
            }
            System.out.println();
        } else {
            System.out.println(description + ": пути нет");
        }
    }

    private static void demonstratePower(String[] args) {
        System.out.println("--- ВОЗВЕДЕНИЕ В СТЕПЕНЬ ---");
        double result = power(args[0], args[1]);
        System.out.println(args[0] + "^" + args[1] + " = " + result);
        System.out.println();
    }
}