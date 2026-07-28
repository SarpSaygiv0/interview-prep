package com.easy.firstnonrepeatingcharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstNonRepeatingCharacterTest {

    FirstNonRepeatingCharacter fnrc;

    @BeforeEach
    void setFnrc() {
        fnrc = new FirstNonRepeatingCharacter();
    }

    @Test
    void checkFirstNonRepeatingCharacter() {
        int expected = 1;
        assertThat(fnrc.firstNonRepeatingCharacter("abcdcaf")).isEqualTo(expected);
    }

    @Test
    void checkFirstNonRepeatingCharacterEmpty() {
        int expected = -1;
        assertThat(fnrc.firstNonRepeatingCharacter("")).isEqualTo(expected);
    }

    @Test
    void checkFirstNonRepeatingCharacterNoRepeating() {
        int expected = -1;
        assertThat(fnrc.firstNonRepeatingCharacter("aabbccdd")).isEqualTo(expected);
    }

    @Test
    void checkFirstNonRepeatingCharacterAtTheEnd() {
        int expected = 8;
        assertThat(fnrc.firstNonRepeatingCharacter("abcddcabf")).isEqualTo(expected);
    }
}
