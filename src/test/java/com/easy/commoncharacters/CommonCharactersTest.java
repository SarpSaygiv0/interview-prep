package com.easy.commoncharacters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonCharactersTest {

    CommonCharacters cc;

    @BeforeEach
    void setCC() {
        cc = new CommonCharacters();
    }

    @Test
    void commonCharactersTest() {
        String[] input = new String[] {"abc", "bcd", "cbad"};
        String[] expected = new String[] {"b", "c"};
        String[] actual = cc.commonCharacters(input);
        Arrays.sort(actual);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void commonCharactersTest2() {
        String[] input = new String[] {"abc", "bcd", "cbad"};
        String[] expected = new String[] {"b", "c"};
        String[] actual = cc.commonCharactersSet(input);
        Arrays.sort(actual);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
