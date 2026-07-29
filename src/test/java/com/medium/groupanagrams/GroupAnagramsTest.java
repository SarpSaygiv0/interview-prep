package com.medium.groupanagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAnagramsTest {

    GroupAnagrams ga;

    @BeforeEach
    void setGa() {
        ga = new GroupAnagrams();
    }

    @Test
    void groupAnagramsTest() {
        List<String> words = new ArrayList<>(List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of("yo", "oy")));
        expected.add(new ArrayList<>(List.of("flop", "olfp")));
        expected.add(new ArrayList<>(List.of("act", "tac", "cat")));
        expected.add(new ArrayList<>(List.of("foo")));
        List<List<String>> output = ga.groupAnagrams(words);
        for (List<String> innerList : output) {
            innerList.sort(Comparator.naturalOrder());
        }
        assertTrue(compare(expected, output));
    }

    public boolean compare(
            List<List<String>> expected, List<List<String>> output
    ) {
        if (expected.size() != output.size()) return false;

        for (List<String> group : expected) {
            group.sort(Comparator.naturalOrder());
            if (!output.contains(group)) return false;
        }

        return true;
    }
}
