package ru.kaufutdinova.cities;

import java.util.Map;

/**
 * Задача 3.3 - Двусторонняя дорога
 */
public class BidirectionalCity extends City {
    public BidirectionalCity(String name) {
        super(name);
    }

    public BidirectionalCity(String name, Map<City, Integer> paths) {
        super(name);
        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            addPath(entry.getKey(), entry.getValue());
        }
    }

    // Задача 3.3: При добавлении дороги автоматически добавляется обратная дорога
    @Override
    public void addPath(City city, int cost) {
        if (city == this) return;

        addOneWayPath(city, cost);

        if (!(city instanceof BidirectionalCity)) {
            city.addOneWayPath(this, cost);
        } else {
            city.addOneWayPath(this, cost);
        }
    }

    @Override
    public void removePath(City city) {
        super.removePath(city);
        if (city != this) {
            city.removePath(this);
        }
    }

    // Задача 6.5: Двусторонний город сравним с обычным городом
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}