package model;

import annotations.Cache;

/**
 * Класс для демонстрации работы аннотации @Cache.
 * Содержит "дорогую" операцию, результат которой можно кешировать.
 */
@Cache({"users", "products", "sessions"}) // три кешируемые области
public class CacheDemo {

    // Поле для хранения закешированного результата
    private String cachedValue;

    /**
     * Метод имитирует дорогую операцию.
     * Если значение уже вычислено — возвращается кеш.
     */
    public String loadData() {
        if (cachedValue != null) {
            return cachedValue; // возвращаем кеш
        }
        cachedValue = "expensive-result"; // имитация долгой операции
        return cachedValue;
    }
}
