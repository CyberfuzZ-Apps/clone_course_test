package ru.parsentev.task_016;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class TicTacToe {
    private static final Logger log = getLogger(TicTacToe.class);

    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        for (int i = 0; i < values.length; i++) {
            if (horizontal(i) || vertical(i)) {
                return true;
            }
        }
        return diagonalLeft() || diagonalRight();
    }

    public boolean horizontal(int row) {
        for (int i = 0; i < values[row].length; i++) {
            if (values[row][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean vertical(int cell) {
        for (int i = 0; i < values.length; i++) {
            if (values[i][cell] != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean diagonalLeft() {
        for (int i = 0; i < values.length; i++) {
            if (values[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean diagonalRight() {
        for (int i = 0; i < values.length; i++) {
            if (values[i][values.length - 1 - i] != 1) {
                return false;
            }
        }
        return true;
    }
}
