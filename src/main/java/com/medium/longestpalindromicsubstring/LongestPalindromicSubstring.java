package com.medium.longestpalindromicsubstring;

public class LongestPalindromicSubstring {


    public String longestPalindromicSubstring(String str) {
        int[] longest = {0, 1};
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPalindrome(str, i - 1, i + 1);
            int[] even = getLongestPalindrome(str, i - 1, i);
            int[] currentLongest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
                    ? currentLongest : longest;
        }
        return str.substring(longest[0], longest[1]);
    }

    public int[] getLongestPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right))
                break;
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }
}
