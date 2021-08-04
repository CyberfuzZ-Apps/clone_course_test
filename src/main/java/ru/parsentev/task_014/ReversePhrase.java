package ru.parsentev.task_014;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class ReversePhrase {
    private static final Logger log = getLogger(ReversePhrase.class);
    private final String line;

    public ReversePhrase(final String line) {
        this.line = line;
    }

    public String reverse() {
        Scanner scanner = new Scanner(line);
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        if (list.size() == 1) {
            return line;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i != 0) {
                sb.append(list.get(i)).append(" ");
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
