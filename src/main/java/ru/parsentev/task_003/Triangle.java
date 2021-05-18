package ru.parsentev.task_003;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Реализовать класс треугольник. Треугольник должен описываться через точки в системе координат.
 * Объект треугольник должен иметь методы: boolean exists() - проверяет существует ли треугольник
 * или нет. double area() - вычисляет площадь треугольника. Если треугольник не существует
 * выбросить исключение java.lang.IllegalStateException
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Triangle {
    private static final Logger log = getLogger(Triangle.class);

    protected final Point first;
    protected final Point second;
    protected final Point third;

    public Triangle(final Point first, final Point second, final Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean exists() {
        double a = first.distanceTo(second);
        double b = second.distanceTo(third);
        double c = third.distanceTo(first);
        return a + b > c && b + c > a && c + a > b;
    }

    public double area() {
        if (!exists()) {
            throw new IllegalStateException();
        }
        double a = first.distanceTo(second);
        double b = second.distanceTo(third);
        double c = third.distanceTo(first);
        double p = (a + b + c) / 2;
        return Math.round(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}
