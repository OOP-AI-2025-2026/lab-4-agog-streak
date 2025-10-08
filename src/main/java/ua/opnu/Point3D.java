package ua.opnu;

import ua.opnu.java.inheritance.point.Point;

public class Point3D extends Point {
    private int z;

    // Конструктор без параметрів (0,0,0)
    public Point3D() {
        super(); // x = 0, y = 0
        this.z = 0;
    }

    // Конструктор з трьома координатами
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    // Геттер для координати z
    public int getZ() {
        return z;
    }

    // Сеттер для трьох координат
    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    // Перевантаження методу setLocation(x, y) — z = 0
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    // Обчислення відстані до іншої точки 3D
    public double distance(Point3D p) {
        int dx = this.getX() - p.getX();
        int dy = this.getY() - p.getY();
        int dz = this.z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Перевизначення distanceFromOrigin для 3D
    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    // Перевизначення toString для виводу трьох координат
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}

