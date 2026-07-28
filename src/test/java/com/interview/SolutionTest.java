package com.interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This file doubles as your JUnit 5 cheat sheet.
 * Every pattern you need in the interview is demonstrated below.
 *
 * Test list (write yours as comments like this during the interview):
 * [x] greets a name
 * [x] handles multiple names (parameterized)
 * [ ] rejects null input
 */
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("greets a single name")
    void greetsName() {
        // plain JUnit assertion
        assertEquals("Hello, Sarp", solution.greet("Sarp"));

        // AssertJ fluent style (nicer failure messages, use whichever you prefer)
        assertThat(solution.greet("Sarp")).isEqualTo("Hello, Sarp");
    }

    @ParameterizedTest(name = "greet({0}) -> {1}")
    @CsvSource({
            "Ada,   'Hello, Ada'",
            "Linus, 'Hello, Linus'",
            "'',    'Hello, '"
    })
    @DisplayName("greets many names (edge-case table in one test)")
    void greetsManyNames(String input, String expected) {
        assertThat(solution.greet(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("exception assertion pattern")
    void exceptionPattern() {
        assertThatThrownBy(() -> Integer.parseInt("not a number"))
                .isInstanceOf(NumberFormatException.class);
    }

}
