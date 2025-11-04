package ru.kaufutdinova.utils;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * Задача 7.3 - Возведение в степень
 */
public class MathUtils {
    // Задача 7.3: Возведение в степень с использованием коротких имен методов
    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }
}