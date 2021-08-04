package ru.parsentev.task_009;

import java.util.*;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class UniqueChars {
    private final String line;

    public UniqueChars(final String line) {
        this.line = line;
    }

    public int unique() {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            set.add(line.charAt(i));
        }
        return set.size();
    }
}
