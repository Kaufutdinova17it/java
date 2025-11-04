package ru.kaufutdinova.cities;

import java.util.*;

/**
 * Задача 2.5 - Маршрут
 */
public class Route {
    private City start;
    private City end;

    // Задача 2.5: Инициализация только с указанием начала и конца
    public Route(City start, City end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end cities cannot be null");
        }
        this.start = start;
        this.end = end;
    }

    public City getStart() { return start; }
    public City getEnd() { return end; }

    // Задача 2.5: Можно изменить начало и конец (O(1) время)
    public void setStart(City start) {
        if (start == null) throw new IllegalArgumentException("Start city cannot be null");
        this.start = start;
    }

    public void setEnd(City end) {
        if (end == null) throw new IllegalArgumentException("End city cannot be null");
        this.end = end;
    }

    // Задача 2.5: Возвращает массив городов маршрута
    public City[] getRoute() {
        Map<City, City> previous = new HashMap<>();
        Queue<City> queue = new LinkedList<>();
        Set<City> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        previous.put(start, null);

        while (!queue.isEmpty()) {
            City current = queue.poll();

            if (current.equals(end)) {
                return buildPath(previous);
            }

            for (City neighbor : current.getPaths().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        return new City[0]; // Путь не найден
    }

    private City[] buildPath(Map<City, City> previous) {
        List<City> path = new ArrayList<>();
        City current = end;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);
        return path.toArray(new City[0]);
    }

    // Задача 2.5: Приведение маршрута к строке
    @Override
    public String toString() {
        City[] route = getRoute();
        if (route.length == 0) {
            return "Маршрут не найден";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < route.length; i++) {
            sb.append(route[i].getName());
            if (i < route.length - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}