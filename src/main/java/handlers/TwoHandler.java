package handlers;

import annotations.Two;

/**
 * Обработчик аннотации @Two.
 */
public class TwoHandler {

    /**
     * Выводит значения свойств аннотации.
     *
     * @param obj объект
     */
    public void process(Object obj) {
        Two annotation = obj.getClass().getAnnotation(Two.class);
        if (annotation != null) {
            System.out.println("first = " + annotation.first());
            System.out.println("second = " + annotation.second());
        }
    }
}
