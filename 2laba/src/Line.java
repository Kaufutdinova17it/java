public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    public Point getStart() {
        return start;
    }
    public Point getEnd() {
        return end;
    }
    public int length() {
        double deltaX = end.getX() - start.getX();
        double deltaY = end.getY() - start.getY();
        return (int) Math.round(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
    }
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}