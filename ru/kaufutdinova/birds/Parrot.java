package ru.kaufutdinova.birds;

import java.util.Random;

/**
 * Задача 4.3 - Попугай
 */
public class Parrot extends Bird {
    private String text;
    private Random random;

    public Parrot(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        this.text = text;
        this.random = new Random();
    }

    @Override
    public void sing() {
        // Выводит первые N символов (1 <= N <= длина текста)
        int n = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, n));
    }

    public String getText() { return text; }
}