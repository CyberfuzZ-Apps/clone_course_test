package ru.parsentev.task_018;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Pool {
    private static final Logger log = getLogger(Pool.class);

    private final int[][] values;

    public Pool(final int[][] values) {
        this.values = values;
    }

    public int maxUnion() {
        int count = 0;
        int first = 0;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values[i].length - 1; j++) {
                if (values[i][j] == 1) {
                    first++;
                }
                if (values[i][j] == 1 && values[i][j + 1] == 1) {
                    count++;
                }
                if (values[i][j] == 1 && values[i + 1][j] == 1) {
                    count++;
                }
                if (j == values[i].length - 1) {
                    if (values[i][j + 1] == 1 && values[i + 1][j + 1] == 1) {
                        count++;
                    }
                }
            }
        }
        if (count == values.length * values[0].length - 1) {
            return ++count;
        }
        for (int i = 0; i < values[values.length - 1].length - 1; i++) {
            if (values[values.length - 1][i] == 1 && values[values.length - 1][i + 1] == 1) {
                count++;
            }
        }
        if (first == 1) {
            count = first;
        } else if (first > 1) {
            count++;
        }
        return count;
    }
}
