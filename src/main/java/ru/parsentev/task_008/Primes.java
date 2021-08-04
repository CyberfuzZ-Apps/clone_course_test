package ru.parsentev.task_008;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: Реализовать класс вычисляющий простые числа до N.
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Primes {
    private static final Logger LOG = getLogger(Primes.class);

    private final int limit;

    public Primes(final int limit) {
        this.limit = limit;
    }

    public List<Integer> calc() {
        List<Integer> result = new ArrayList<>();
        if (limit < 2) {
            return List.of();
        } else {
            result.add(2);
        }
        for (int i = 3; i <= limit; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                } else if (j != i - 1) {
                    continue;
                }
                result.add(i);
            }
        }
        return result;
    }
}
