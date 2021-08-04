package ru.parsentev.task_015;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CycleShift {
    private static final Logger log = getLogger(CycleShift.class);

    private final int[] values;

    public CycleShift(final int[] values) {
        this.values = values;
    }

    public int[] shift(int position) {
        int tmp = 0;
        for (int i = 0; i < position; i++) {
            tmp = values[values.length - 1];
            for (int j = values.length - 1; j > 0; j--) {
                values[j] = values[j - 1];
            }
            values[0] = tmp;
        }
        return values;
    }
}
