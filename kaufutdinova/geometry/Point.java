package ru.kaufutdinova.geometry;

/**
 * Задача 8.4 - Клонирование точки
 */
public class Point implements Cloneable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    @Override
    public String toString() {
        return "{ " + x + "; " + y + " }";
    }

    // Задача 8.4: Клонирование точки
    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            // Этот блок никогда не выполнится, так как Point implements Cloneable
            throw new AssertionError("Clone not supported", e);
        }
    }

    @Override
    //сравниваем две точки
    public boolean equals(Object obj) {
        //это один и тот же объект?
        if (this == obj)
            return true;
        //объект не null и того же класса?
        if (obj == null || getClass() != obj.getClass())
            return false;
        //совпадают ли координаты?
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }
}