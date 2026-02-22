package ru.kaufutdinova.cities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class City {
    private String name;
    private Map<City, Integer> roads;

    public City(String name) {
        this.name = name;
        this.roads = new HashMap<>();
    }

    // Добавить двусторонную дорогу в другой город
    public void addRoad(City to, int price) {
        //нельзя добавить дорогу в себя или если дороги еще нет
        if (to != this && !roads.containsKey(to)) {
            roads.put(to, price);
        }
    }

    // Добавить одностороннюю дорогу
    public void addOneWayRoad(City to, int price) {
        if (to != this && !roads.containsKey(to)) {
            roads.put(to, price);
        }
    }

    // Удалить дорогу
    public void removeRoad(City to) {
        roads.remove(to);
    }

    // Геттеры
    public String getName() {
        return name;
    }
    //Возвращает копию карты дорог,чтобы никто снаружи не смог изменить
    public Map<City, Integer> getRoads() {
        return new HashMap<>(roads);
    }

    @Override
    public String toString() {
        if (roads.isEmpty()) {
            return name + ": нет дорог";
        }

        StringBuilder result = new StringBuilder(name + " ведёт в:\n");
        for (Map.Entry<City, Integer> entry : roads.entrySet()) {
            result.append("  → ").append(entry.getKey().name)
                    .append(" (цена ").append(entry.getValue()).append(")\n");
        }
        return result.toString();
    }

    // Два города равны если:
    // 1. Одинаковые имена
    // 2. Одинаковые дороги (в те же города и по той же цене)
    @Override
    public boolean equals(Object obj) {
        //это один и тот же объект?
        if (this == obj) return true;
        //если объект нулевой или если объект не является City
        if (obj == null || !(obj instanceof City)) return false;
        //Приводим объект к типу City, чтобы работать с его полями.
        City other = (City) obj;

        // Сравниваем имена
        if (!this.name.equals(other.name)) return false;

        // Сравниваем дороги по названиям городов
        //создаем пустую карту
        Map<String, Integer> myRoads = new HashMap<>();
        //проходимся по всем дорогам города и для каждой дороги берем:
        //имя города и цену дороги
        for (Map.Entry<City, Integer> entry : roads.entrySet()) {
            //Кладём в карту пару: Имя города -> цена
            myRoads.put(entry.getKey().name, entry.getValue());
        }
        //
        Map<String, Integer> otherRoads = new HashMap<>();
        for (Map.Entry<City, Integer> entry : other.roads.entrySet()) {
            otherRoads.put(entry.getKey().name, entry.getValue());
        }
        //сравниваем две карты дорог
        return myRoads.equals(otherRoads);
    }

    @Override
    //строим хэш коды по имени города и всех его дорог.
    //число, которое Java вычисляет для объекта, чтобы быстро искать его в коллекциях
    public int hashCode() {
        int result = name.hashCode();
        for (Map.Entry<City, Integer> entry : roads.entrySet()) {
            result = 31 * result + entry.getKey().name.hashCode();
            result = 31 * result + entry.getValue();
        }
        return result;
    }
}