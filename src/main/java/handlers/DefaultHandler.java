package handlers;

import annotations.Default;

/**
 * Обработчик аннотации @Default.
 */
public class DefaultHandler {

    /**
     * Выводит тип по умолчанию, указанный в аннотации.
     *
     * @param obj объект для анализа
     */
    public void process(Object obj) {
        Default annotation = obj.getClass().getAnnotation(Default.class);
        if (annotation != null) {
            System.out.println("Тип по умолчанию: " + annotation.value().getName());
        }
    }
}
