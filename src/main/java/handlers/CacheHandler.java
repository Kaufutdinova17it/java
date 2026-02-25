package handlers;

import annotations.Cache;

/**
 * Обработчик аннотации @Cache.
 * Считывает список кешируемых областей и выводит их.
 */
public class CacheHandler {

    /**
     * Метод выводит список кешируемых областей.
     * Если массив пуст — сообщает, что кеширование отключено.
     */
    public void process(Class<?> type) {
        Cache annotation = type.getAnnotation(Cache.class);

        // Если аннотация отсутствует
        if (annotation == null) {
            System.out.println("Аннотация @Cache отсутствует у класса " + type.getSimpleName());
            return;
        }

        String[] regions = annotation.value();

        // Если массив пуст
        if (regions.length == 0) {
            System.out.println("Кеширование отключено: список областей пуст.");
            return;
        }

        // Выводим список областей
        System.out.println("Кешируемые области для класса " + type.getSimpleName() + ":");
        for (String region : regions) {
            System.out.println(" - " + region);
        }
    }
}
