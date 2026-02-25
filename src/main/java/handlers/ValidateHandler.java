package handlers;

import annotations.Validate;

/**
 * Обработчик аннотации @Validate.
 */
public class ValidateHandler {

    /**
     * Выводит список классов, указанных в аннотации.
     *
     * @param obj объект
     */
    public void process(Object obj) {
        Validate annotation = obj.getClass().getAnnotation(Validate.class);
        if (annotation != null) {
            for (Class<?> clazz : annotation.value()) {
                System.out.println("Класс для проверки: " + clazz.getName());
            }
        }
    }
}
