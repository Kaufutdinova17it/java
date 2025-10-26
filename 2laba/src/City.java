import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> paths;

    public City(String name) {
        this.name = name;
        this.paths = new HashMap<>();
    }

    // Новый конструктор, принимающий название города и связи с другими городами
    public City(String name, Map<City, Integer> paths) {
        this.name = name;
        this.paths = new HashMap<>(paths);
    }

    public void addPath(City city, int cost) {
        paths.put(city, cost);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String result = name + ":\n";
        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            result += "  " + entry.getKey().getName() + ": " + entry.getValue() + "\n";
        }
        return result;
    }
}