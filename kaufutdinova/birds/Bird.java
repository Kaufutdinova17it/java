package ru.kaufutdinova.birds;

/**
 * Задача 4.3 - Птицы (корень иерархии)
 */
public abstract class Bird {
    //abstract void sing() — метод без реализации.
    //Каждая конкретная птица обязана переопределить его.
    public abstract void sing();
}