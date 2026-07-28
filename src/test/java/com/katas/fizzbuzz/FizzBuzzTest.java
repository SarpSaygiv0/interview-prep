package com.katas.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    FizzBuzz fb;

    @BeforeEach
    void setFizzBuzz() {
        fb = new FizzBuzz();
    }

    @Test
    void fizzBuzzShouldReturnNumberWhenTheNumberIsNotDivisibleByThreeOrFive() {
        String expected = "1";
        assertThat(fb.fizzBuzz(1)).isEqualTo(expected);
    }
    @Test
    void fizzBuzzShouldReturnFizzWhenTheNumberIsDivisibleByThree() {
        String expected = "Fizz";
        assertThat(fb.fizzBuzz(6)).isEqualTo(expected);
    }
    @Test
    void fizzBuzzShouldReturnBuzzWhenTheNumberIsDivisibleByFive() {
        String expected = "Buzz";
        assertThat(fb.fizzBuzz(10)).isEqualTo(expected);
    }

    @Test
    void fizzBuzzShouldReturnFizzFizzBuzzWhenTheNumberIsDivisibleByFiveAndThree() {
        String expected = "FizzFizzBuzz";
        assertThat(fb.fizzBuzz(30)).isEqualTo(expected);
    }

    // Stage2
    @Test
    void fizzBuzzShouldReturnFizzBuzzWhenTheNumberHasThreeAndFiveInIt(){
        String expected = "FizzBuzz";
        assertThat(fb.fizzBuzz(53)).isEqualTo(expected);
    }


    @Test
    void fizzBuzzShouldReturnFizzBuzzBuzzWhenTheNumberHasFiveInItAndDivisibleByFive(){
        String expected = "FizzBuzzBuzz";
        assertThat(fb.fizzBuzz(35)).isEqualTo(expected);
    }

    @Test
    void fizzBuzzShouldReturnFizzBuzzBuzzWhenTheNumberHasFiveInItAndDivisibleByThreeAndFive(){
        String expected = "FizzBuzzBuzz";
        assertThat(fb.fizzBuzz(15)).isEqualTo(expected);
    }

    @Test
    void fizzBuzzShouldReturnFizzFizzBuzzBuzzWhenTheNumberHasThreeAndFiveInItAndDivisibleByThreeAndFive(){
        String expected = "FizzFizzBuzzBuzz";
        assertThat(fb.fizzBuzz(135)).isEqualTo(expected);
    }

    @Test
    void fizzBuzzShouldReturnFizzFizzWhenTheNumberIsThree(){
        String expected = "FizzFizz";
        assertThat(fb.fizzBuzz(3)).isEqualTo(expected);
    }

    @Test
    void fizzBuzzShouldReturnBuzzWhenTheNumberNotDivisibleByFiveOrThreeButHasFiveInIt(){
        String expected = "Buzz";
        assertThat(fb.fizzBuzz(52)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "fizzBuzz({0}) should be \"{1}\"")
    @CsvSource({
            // input, expected
            "1,    1",                  // no rule applies
            "6,    Fizz",               // divisible by 3
            "10,   Buzz",               // divisible by 5
            "3,    FizzFizz",           // divisible by 3 AND contains 3
            "52,   Buzz",               // contains 5 only
            "53,   FizzBuzz",           // contains 3 and 5
            "35,   FizzBuzzBuzz",       // contains 3, contains 5, divisible by 5
            "30,   FizzFizzBuzz",       // contains 3, divisible by 3 and 5
            "15,   FizzBuzzBuzz",       // divisible by 3 and 5, contains 5
            "135,  FizzFizzBuzzBuzz"    // everything at once
    })
    void fizzBuzzReturnsExpectedWord(int input, String expected) {
        assertThat(fb.fizzBuzz(input)).isEqualTo(expected);
    }
}
