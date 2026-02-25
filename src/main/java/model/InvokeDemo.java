package model;

import annotations.Invoke;

/**
 * Класс с методами, один из которых помечен @Invoke.
 */
public class InvokeDemo {

    /** Обычный метод. */
    public void sayHello() {
        System.out.println("Привет!");
    }

    /** Метод, который будет вызван автоматически. */
    @Invoke
    public void autoRun() {
        System.out.println("Метод с @Invoke выполнен автоматически.");
    }
}
