package com.medium.longesubstrworepeatingchars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstringWithoutRepeatingCharactersTest {

    LongestSubstringWithoutRepeatingCharacters lssWoRepeatingChars;

    @BeforeEach
    void setLssWithoutRepeatingChars() {
        lssWoRepeatingChars = new LongestSubstringWithoutRepeatingCharacters();
    }

    @Test
    void longestSubstringWithoutRepeatingCharactersTest() {
        String input = "abcabcbb";

        assertThat(lssWoRepeatingChars.lengthOfLongestSubstring(input)).isEqualTo(3);
    }

    @Test
    void longestSubstringWithoutRepeatingCharactersTest2() {
        String input = "pwwkew";

        assertThat(lssWoRepeatingChars.lengthOfLongestSubstring(input)).isEqualTo(3);
    }

    @Test
    void longestSubstringWithoutRepeatingCharactersTest3() {
        String input = "abcadcbb";
        assertThat(lssWoRepeatingChars.lengthOfLongestSubstring(input)).isEqualTo(4);
    }
}
