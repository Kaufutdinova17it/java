package ru.kaufutdinova.cities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Задача 1.10 - Дороги
 * Задача 6.5 - Сравнение городов
 */
public class City {
    private String name;
    private Map<City, Integer> paths;

    public City(String name) {
        this.name = name;
        this.paths = new HashMap<>();
    }

    public City(String name, Map<City, Integer> paths) {
        this.name = name;
        this.paths = new HashMap<>(paths);
    }

    // Задача 1.10: Гарантирует, что между двумя городами может быть только одна прямая дорога
    public void addPath(City city, int cost) {
        if (city != this && !paths.containsKey(city)) {
            paths.put(city, cost);
        }
    }

    public void addOneWayPath(City city, int cost) {
        if (city != this && !paths.containsKey(city)) {
            paths.put(city, cost);
        }
    }

    // Задача 1.10: Можно удалить имеющуюся дорогу
    public void removePath(City city) {
        paths.remove(city);
    }

    public String getName() { return name; }
    public Map<City, Integer> getPaths() { return new HashMap<>(paths); }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name + ":\n");
        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            result.append("  ").append(entry.getKey().getName()).append(": ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    // Задача 6.5: Сравнение городов по имени
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}