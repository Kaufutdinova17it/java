package ru.kaufutdinova.cities;

import java.util.*;
// это объект умеющий искать путь между двумя городами по дорогам
public class Route {
    private City from;
    private City to;

    public Route(City from, City to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Города не могут быть null");
        }
        this.from = from;
        this.to = to;
    }

    public City getFrom() { return from; }
    public City getTo() { return to; }

    public void setFrom(City from) {
        if (from == null) throw new IllegalArgumentException("from не может быть null");
        this.from = from;
    }

    public void setTo(City to) {
        if (to == null) throw new IllegalArgumentException("to не может быть null");
        this.to = to;
    }

    // Найти путь из from в to
    public City[] findPath() {
        //Если маршрут начинается и заканчивается в одном городе
        // — путь состоит из одного элемента.
        if (from.equals(to)) {
            return new City[]{from};
        }

        // Для поиска используем обход в ширину (BFS)
        Map<City, City> previous = new HashMap<>(); // откуда пришли в город
        Queue<City> queue = new LinkedList<>();
        Set<City> visited = new HashSet<>();

        queue.add(from);
        visited.add(from);
        previous.put(from, null);

        while (!queue.isEmpty()) {
            City current = queue.poll();

            // Проверяем все дороги ИЗ текущего города
            for (City next : current.getRoads().keySet()) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    previous.put(next, current);

                    if (next.equals(to)) {
                        return buildPath(previous); // Нашли путь
                    }

                    queue.add(next);
                }
            }
        }

        return new City[0]; // Путь не найден
    }

    // Собрать путь из карты previous
    private City[] buildPath(Map<City, City> previous) {
        List<City> path = new ArrayList<>();
        City current = to;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path); // Разворачиваем
        return path.toArray(new City[0]);
    }

    // Показать маршрут
    @Override
    public String toString() {
        City[] path = findPath();

        if (path.length == 0) {
            return "Нет пути из " + from.getName() + " в " + to.getName();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length; i++) {
            sb.append(path[i].getName());
            if (i < path.length - 1) {
                sb.append(" → ");
            }
        }
        return sb.toString();
    }
}