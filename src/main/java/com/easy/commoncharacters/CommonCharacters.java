package com.easy.commoncharacters;

import java.util.*;

public class CommonCharacters {

    // Solution 1
    public String[] commonCharacters(String[] strings) {
        Map<String, Integer> freq = new HashMap<>();
        HashSet<Character> setStr = new HashSet<>();
        for (String str : strings) {
            for (char c : str.toCharArray())
                setStr.add(c);

            for (char c: setStr)
                freq.put(
                        String.valueOf(c),
                        freq.getOrDefault(String.valueOf(c), 0) + 1
                );
            setStr.clear();
        }
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> element : freq.entrySet()) {
            if (element.getValue() == strings.length) {
                result.add(element.getKey());
            }
        }

        return result.toArray(String[]::new);
    }

    // Solution 2
    public String[] commonCharactersSet(String[] strs) {
        Set<Character> seen = new HashSet<>();

        for (char c : strs[0].toCharArray())
            seen.add(c);

        for (String str: strs) {
            Set<Character> curr = new HashSet<>();
            for(Character c : str.toCharArray()) {
                curr.add(c);
            }
            seen.retainAll(curr);
        }

        return seen.stream().map(String::valueOf).toArray(String[]::new);
    }
}
