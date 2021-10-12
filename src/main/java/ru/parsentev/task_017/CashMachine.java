package ru.parsentev.task_017;

import org.slf4j.Logger;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.singletonList;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CashMachine {
    private static final Logger log = getLogger(CashMachine.class);

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        return exchange(note, this.values[this.values.length - 1]);
    }

    private List<List<Integer>> exchange(int note, int maxCoin) {
        List<List<Integer>> result = new ArrayList<>();
        if (note == 0) {
            result = List.of();
        } else {
            for (int i = this.values.length - 1; i >= 0; i--) {
                int coin = values[i];
                if (coin > note || coin > maxCoin) {
                    continue;
                }
                for (List<Integer> remain : exchange(note - coin, coin)) {
                    List<Integer> set = new ArrayList<>();
                    set.add(coin);
                    set.addAll(remain);
                    result.add(set);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CashMachine machine = new CashMachine(new int[] {1, 5, 10});
        List<List<Integer>> result = machine.exchange(10);
        System.out.println(result);
//                                asList(5, 5),
//                                asList(5, 1, 1, 1, 1, 1),
//                                asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)

    }
}
