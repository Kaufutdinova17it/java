package com.example;

import handlers.CacheHandler;
import handlers.DefaultHandler;
import handlers.InvokeHandler;
import handlers.ToStringBuilder;
import handlers.TwoHandler;
import handlers.ValidateHandler;

import java.util.Scanner;

import model.CacheDemo;
import model.DefaultDemo;
import model.InvokeDemo;
import model.Person;
import model.TwoDemo;
import model.ValidateDemo;

/**
 * Главный класс программы.
 * Реализует дружественный интерфейс для демонстрации всех аннотаций.
 */
public class Main {

    /**
     * Точка входа в программу.
     * Содержит меню, проверку ввода и вызов обработчиков.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Демонстрация аннотаций ===");
            System.out.println("1 — @Invoke");
            System.out.println("2 — @Default");
            System.out.println("3 — @ToString");
            System.out.println("4 — @Validate");
            System.out.println("5 — @Two");
            System.out.println("6 — @Cache");
            System.out.println("0 — Выход");

            int choice = readInt(scanner, "Выберите пункт меню: ");

            switch (choice) {
                case 1 -> {
                    System.out.println("\n=== Демонстрация @Invoke ===");
                    new InvokeHandler().process(new InvokeDemo());
                }
                case 2 -> {
                    System.out.println("\n=== Демонстрация @Default ===");
                    new DefaultHandler().process(DefaultDemo.class);
                }
                case 3 -> runToStringDemo(scanner);
                case 4 -> {
                    System.out.println("\n=== Демонстрация @Validate ===");
                    new ValidateHandler().process(ValidateDemo.class);
                }
                case 5 -> {
                    System.out.println("\n=== Демонстрация @Two ===");
                    new TwoHandler().process(TwoDemo.class);
                }
                case 6 -> runCacheDemo();
                case 0 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Нет такого пункта.");
            }
        }
    }

    /**
     * Безопасное чтение целого числа с проверкой ввода.
     */
    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Ошибка: введите число!");
            scanner.next(); // очищаем неверный ввод
        }
    }

    /**
     * Демонстрация работы аннотации @ToString.
     * Пользователь вводит данные, затем формируется строковое представление объекта.
     */
    private static void runToStringDemo(Scanner scanner) {
        scanner.nextLine(); // очистка буфера

        System.out.println("\n=== Демонстрация @ToString ===");

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        int age = readInt(scanner, "Введите возраст: ");
        scanner.nextLine(); // очистка после nextInt()

        System.out.print("Введите город: ");
        String city = scanner.nextLine();

        Person person = new Person(name, age, city);

        System.out.println("Строковое представление объекта:");
        System.out.println(new ToStringBuilder().build(person));
    }

    /**
     * Демонстрация работы аннотации @Cache.
     * Показывает список кешируемых областей и работу "дорогой" операции.
     */
    private static void runCacheDemo() {
        System.out.println("\n=== Демонстрация @Cache ===");

        // Выводим кешируемые области
        new CacheHandler().process(CacheDemo.class);

        // Демонстрация кеширования
        CacheDemo demo = new CacheDemo();

        System.out.println("\nПервый вызов loadData():");
        System.out.println("Результат: " + demo.loadData());

        System.out.println("\nВторой вызов loadData() (должен вернуть кеш):");
        System.out.println("Результат: " + demo.loadData());
    }
}
