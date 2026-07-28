package com.easy.palindromecheck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckTest {

    PalindromeCheck pc;

    @BeforeEach
    void setPc() {
        pc = new PalindromeCheck();
    }

    @Test
    void checkActualPalindrome() {
        assertTrue(pc.isPalindrome("abcdcba"));
    }

    @Test
    void checkEmptyPalindrome() {
        assertTrue(pc.isPalindrome(""));
    }

    @Test
    void checkStringWithEvenLength() {
        assertTrue(pc.isPalindrome("xyzzyx"));
    }

    @Test
    void checkFalsePalindrome() {
        assertFalse(pc.isPalindrome("sarp"));
    }
}
