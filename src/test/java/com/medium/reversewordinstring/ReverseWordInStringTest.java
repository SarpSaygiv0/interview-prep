package com.medium.reversewordinstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ReverseWordInStringTest {
    ReverseWordInString rwis;

    @BeforeEach
    void setRwis() {
        rwis = new ReverseWordInString();
    }

    @Test
    void reverseWordInStringTest() {
        String input = "I love Spider-Man  Movies";
        String expected = "Movies  Spider-Man love I";
        assertThat(rwis.reverseWordInString(input)).isEqualTo(expected);
    }

    @Test
    void reverseWordInStringSimple() {
        String input = "curry is great";
        String expected = "great is curry";
        assertThat(rwis.reverseWordInString(input)).isEqualTo(expected);
    }
}
