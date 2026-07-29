package com.medium.longestpalindromicsubstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring lps;

    @BeforeEach
    void setLps() {
        lps = new LongestPalindromicSubstring();
    }

    @Test
    void longestPalindromicSubstringTest() {
        String input = "abaxyzzyxf";
        String expected = "xyzzyx";

        assertThat(lps.longestPalindromicSubstring(input)).isEqualTo(expected);
    }

}
