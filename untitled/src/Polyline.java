import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}