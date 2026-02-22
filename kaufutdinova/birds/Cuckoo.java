package ru.kaufutdinova.birds;

import java.util.Random;

/**
 * Задача 4.3 - Кукушка
 */
public class Cuckoo extends Bird {
    private Random random = new Random();

    @Override
    public void sing() {
        //рандомайзер дает число от 1 до 10
        int count = random.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            //Добавляем пробел между «ку‑ку», но не после последнего
            System.out.print("ку-ку");
            if (i < count - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}