package ru.kaufutdinova.geometry;

/**
 * Задача 3.5 - Трехмерная точка
 */
public class Point3D extends Point {
    private double z;

    // Задача 3.5: Точка с тремя координатами X, Y, Z
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    @Override
    public String toString() {
        return "{ " + getX() + "; " + getY() + "; " + z + " }";
    }

    // Задача 8.4: Клонирование трехмерной точки
    @Override
    public Point3D clone() {
        //Сначала клонируем родительскую часть (x, y),
        Point3D cloned = (Point3D) super.clone();
        //затем клонируем z
        cloned.setZ(this.z);
        return cloned;
    }

    @Override
    public boolean equals(Object obj) {
        //сравниваем x и y.
        //Если они не совпадают → сразу false.
        if (!super.equals(obj)) return false;
        Point3D point3D = (Point3D) obj;
        //сравниваем z
        return Double.compare(point3D.z, z) == 0;
    }
}