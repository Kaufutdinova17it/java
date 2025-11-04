package ru.kaufutdinova.utils;

import java.util.Scanner;

public class ForPoint {
    Scanner scanner = new Scanner(System.in);

    public double Coordinate(String coordinate) {
        double c;
        while (true) {
            System.out.print("Введите координату " + coordinate + ": ");
            if (scanner.hasNextDouble()) {
                c = scanner.nextDouble();
                scanner.nextLine();
                return c;
            } else {
                System.out.println("Ошибка! Пожалуйста введите число: ");
                scanner.nextLine();
            }
        }
    }
}