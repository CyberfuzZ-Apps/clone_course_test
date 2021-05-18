package ru.parsentev.task_004;

import org.slf4j.Logger;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_003.Triangle;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Реализовать класс равнобедренный треугольник наследуя класс треугольник из задания 3.
 * Дополнить поведение метода boolean exists() - true, если треугольник равнобедренный.
 * Остальное поведение оставить прежним.
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class IsoscelesTriangle extends Triangle {
    private static final Logger log = getLogger(IsoscelesTriangle.class);

    public IsoscelesTriangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    @Override
    public boolean exists() {
        double a = first.distanceTo(second);
        double b = second.distanceTo(third);
        double c = third.distanceTo(first);
        return super.exists() && (a == b || b == c || c == a);
    }
}
