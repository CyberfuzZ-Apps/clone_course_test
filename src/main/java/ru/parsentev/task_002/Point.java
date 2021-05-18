package ru.parsentev.task_002;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Реализовать класс точку, описывающую точку в системе координат x, y - Point(x, y).
 * Объект точка должен иметь методы double Point#distanceTo(Point point) -
 * метод должен вычислять расстояние между двумя точками.
 *
 * Class Point defines a point in coordination system (x, y).
 * @author parsentev
 * @since 19.07.2016
 */
public class Point {
    private static final Logger log = getLogger(Point.class);

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(final Point point) {
        int x = point.x - this.x;
        int y = point.y - this.y;
        return x + y;
    }
}
