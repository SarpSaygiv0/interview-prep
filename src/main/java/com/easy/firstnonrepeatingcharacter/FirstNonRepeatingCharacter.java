package com.easy.firstnonrepeatingcharacter;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public int firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i<str.length(); i++) {
            if (freq.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
