package ru.parsentev.task_005;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_003.Triangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Реализовать класс прямоугольный треугольник наследуя класс треугольник из задания 3.
 * Дополнить поведение метода boolean exists() - true, если треугольник равносторонний
 * (скорее тут опечатка - не равносторонни, а равнобедренный).
 * Остальное поведение оставить прежним.
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class RightTriangle extends Triangle {
    private static final Logger log = getLogger(RightTriangle.class);

    public RightTriangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    @Override
    public boolean exists() {
        double aPow2 = Math.round(Math.pow(first.distanceTo(second), 2));
        double bPow2 = Math.round(Math.pow(second.distanceTo(third), 2));
        double cPow2 = Math.round(Math.pow(third.distanceTo(first), 2));
        return super.exists() && (aPow2 + bPow2 == cPow2
                || bPow2 + cPow2 == aPow2 || cPow2 + aPow2 == bPow2);
    }
}
