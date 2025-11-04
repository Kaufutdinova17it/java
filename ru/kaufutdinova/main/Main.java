package ru.kaufutdinova.main;

import ru.kaufutdinova.cities.*;
import ru.kaufutdinova.geometry.*;
import ru.kaufutdinova.birds.*;
import ru.kaufutdinova.utils.*;
import static ru.kaufutdinova.utils.MathUtils.power;

import java.util.*;

/**
 * Задача 7.1 - Организация по пакетам
 * Задача 7.2 - Главный метод
 * Задача 5.9 - Реализация графа городов
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Демонстрация работы с точками
        System.out.println("=== Демонстрация работы с точками ===");
        Point point = new Point(5, 10);
        Point3D point3D = new Point3D(1, 2, 3);
        System.out.println("Точка 2D: " + point);
        System.out.println("Точка 3D: " + point3D);

        Point clonedPoint = point.clone();
        System.out.println("Клонированная точка: " + clonedPoint);

        // Демонстрация работы с городами и маршрутами
        System.out.println("\n=== Демонстрация работы с городами ===");
        demonstrateCities();

        // Демонстрация работы с птицами
        System.out.println("\n=== Демонстрация работы с птицами ===");
        demonstrateBirds();

        // Задача 7.3: Возведение в степень с параметрами командной строки
        if (args.length >= 2) {
            System.out.println("\n=== Возведение в степень ===");
            try {
                double result = power(args[0], args[1]);
                System.out.println(args[0] + " в степени " + args[1] + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат чисел в аргументах командной строки");
            }
        }

        scanner.close();
    }

    /**
     * Задача 5.9 - Реализация графа городов
     * Задача 2.5 - Демонстрация маршрутов
     */
    private static void demonstrateCities() {
        // Создаем города согласно условию графа
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");

        System.out.println("Создаем дороги согласно графу:");

        // Задача 5.9: Создание графа с односторонними и двусторонними дорогами
        A.addPath(B, 1);  // A->B (односторонняя)
        System.out.println("A -> B добавлена");

        A.addPath(C, 1);  // A->C (односторонняя)
        System.out.println("A -> C добавлена");

        B.addPath(C, 1);  // B->C (односторонняя)
        System.out.println("B -> C добавлена");

        // B->A не добавляем для избежания цикла
        System.out.println("B -> A не добавляем (избегаем цикла)");

        C.addPath(A, 1);  // C->A (односторонняя)
        System.out.println("C -> A добавлена");

        D.addPath(B, 1);  // D->B (односторонняя)
        System.out.println("D -> B добавлена");

        D.addPath(E, 1);  // D->E (односторонняя)
        System.out.println("D -> E добавлена");

        E.addPath(C, 1);  // E->C (односторонняя)
        System.out.println("E -> C добавлена");

        E.addPath(D, 1);  // E->D (односторонняя)
        System.out.println("E -> D добавлена");

        // Задача 2.5: Тестирование маршрутов
        System.out.println("\n=== Тестирование маршрутов ===");

        Route route1 = new Route(D, A);
        System.out.println("Маршрут из D в A: " + route1);

        Route route2 = new Route(A, E);
        System.out.println("Маршрут из A в E: " + route2);

        Route route3 = new Route(C, D);
        System.out.println("Маршрут из C в D: " + route3);

        Route route4 = new Route(B, E);
        System.out.println("Маршрут из B в E: " + route4);

        // Задача 6.5: Демонстрация сравнения городов
        System.out.println("\n=== Сравнение городов ===");
        City testCity1 = new City("Test1");
        City testCity2 = new City("Test2");
        City testCity3 = new City("Test1");

        System.out.println("Города с одинаковыми именами равны: " + testCity1.equals(testCity3));
        System.out.println("Города с разными именами не равны: " + !testCity1.equals(testCity2));

        // Выводим полную информацию о графе
        System.out.println("\n=== Структура графа ===");
        City[] cities = {A, B, C, D, E};
        for (City city : cities) {
            System.out.println(city);
        }

        // Задача 3.3: Демонстрация двусторонних городов
        System.out.println("\n=== Демонстрация двусторонних городов ===");

        BidirectionalCity F = new BidirectionalCity("F");
        BidirectionalCity G = new BidirectionalCity("G");

        F.addPath(G, 1);
        System.out.println("Двусторонняя дорога F <-> G создана");

        System.out.println("F: " + F);
        System.out.println("G: " + G);

        Route route5 = new Route(F, G);
        System.out.println("Маршрут из F в G: " + route5);

        // Задача 5.9: Маршрут из F в D
        Route routeFD = new Route(F, D);
        System.out.println("Маршрут из F в D: " + routeFD);
    }


    // Задача 4.3 - Демонстрация работы с птицами
    private static void demonstrateBirds() {
        Bird sparrow = new Sparrow();
        Bird cuckoo = new Cuckoo();
        Bird parrot = new Parrot("Привет, я попугай!");

        System.out.print("Воробей: ");
        sparrow.sing();

        System.out.print("Кукушка: ");
        cuckoo.sing();

        System.out.print("Попугай: ");
        parrot.sing();
    }
}