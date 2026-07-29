package com.medium.groupanagrams;

import java.util.*;

public class GroupAnagrams {

    // ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
    // ["oy", "act", "flop", "act", "foo", "act", "oy", "flop"]

    public List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            groupedAnagrams
                    .computeIfAbsent(String.valueOf(arr), k -> new ArrayList<>())
                    .add(word);
        }

        return groupedAnagrams.values().stream().toList();
    }
}
