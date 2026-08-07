package com.medium.longesubstrworepeatingchars;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String str) {
        Set<Character> tracker = new HashSet<>();
        int left = 0;
        int longestLength = 0;
        for (int right = 0; right < str.length(); right++) {
            Character curr = str.charAt(right);
            while (tracker.contains(curr)) {
                tracker.remove(str.charAt(left));
                left++;
            }
            tracker.add(curr);
            int currentLongest = right - left + 1;
            longestLength = Math.max(longestLength, currentLongest);
        }
        return longestLength;
    }
}
