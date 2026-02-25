package handlers;

import annotations.Invoke;
import java.lang.reflect.Method;

/**
 * Обработчик, автоматически вызывающий методы с @Invoke.
 */
public class InvokeHandler {

    /**
     * Находит и вызывает методы, помеченные @Invoke.
     *
     * @param obj объект для анализа
     */
    public void process(Object obj) {
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.invoke(obj);
                } catch (Exception e) {
                    throw new RuntimeException("Ошибка вызова метода: " + method.getName(), e);
                }
            }
        }
    }
}
