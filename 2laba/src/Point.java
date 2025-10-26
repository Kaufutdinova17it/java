public class Point {
    private double x; // рекомендуется использовать lowercase для полей
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override //метод переопределяет метод из родительского класса
    public String toString() {
        return "{ " + x + ";" + y + "}";
    }
}
