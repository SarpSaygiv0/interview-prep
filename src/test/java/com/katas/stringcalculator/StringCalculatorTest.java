package com.katas.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    StringCalculator sc;

    @BeforeEach
    void setSc() {
        sc = new StringCalculator();
    }

    @Test
    void addShouldReturnOWhenEmpty() {
        String input = "";
        assertThat(sc.add(input)).isEqualTo("0");
    }

    @Test
    void addShouldHandleNumbersSeparatedByComma() {
        String input = "1,2";
        assertThat(sc.add(input)).isEqualTo("3");
    }

    @Test
    void addShouldHandleFloatingNumbers() {
        String input = "1.1,2.3,0.4";
        assertThat(sc.add(input)).isEqualTo("3.8");
    }

    @Test
    void addShouldHandleFloatingNumbersWithIntegers() {
        String input = "1.1,2";
        assertThat(sc.add(input)).isEqualTo("3.1");
    }

    @Test
    void addShouldHandleUnknownAmountOfNumbers() {
        String input = "1,2,3,4,5";
        assertThat(sc.add(input)).isEqualTo("15");
    }

    @Test
    void addShouldHandleNewLineAsSeparator() {
        String input = "1\n2,3";
        assertThat(sc.add(input)).isEqualTo("6");
    }

    @Test
    void addShouldHandleReturnErrorMessageWithBreakingSeparatorAndPosition() {
        String input = "175.2,\n35";
        String error = "Number expected but '\\n' found at position 6.";
        assertThat(sc.add(input)).isEqualTo(error);
    }

    @Test
    void addShouldHandleReturnErrorMessageWithSameBreakingSeparatorAndPosition() {
        String input = "175.2,35,44,,12";
        String error = "Number expected but ',' found at position 12.";
        assertThat(sc.add(input)).isEqualTo(error);
    }

    @Test
    void addShouldHandleReturnErrorMessageWithBreakingSeparatorAtTheEnd() {
        String input = "175.2,35\n";
        String error = "Number expected but EOF found.";
        assertThat(sc.add(input)).isEqualTo(error);
    }

    @Test
    void addShouldHandleCustomDelimiter() {
        String input = "//;\n1;2";
        assertThat(sc.add(input)).isEqualTo("3");
    }

    @Test
    void addShouldHandleCustomDelimiterWithRegexCharacter() {
        String input = "//|\n1|2|3";
        assertThat(sc.add(input)).isEqualTo("6");
    }

    @Test
    void addShouldHandleCustomDelimiterMoreThanOneCharacter() {
        String input = "//sep\n2sep3";
        assertThat(sc.add(input)).isEqualTo("5");
    }

    @Test
    void addShouldHandleErrorWhenCustomDelimiterIsConsecutive() {
        String input = "//sep\n2sepsep3";
        assertThat(sc.add(input)).isEqualTo("Number expected but 'sep' found at position 4.");
    }

    @Test
    void addShouldHandleErrorWhenCustomDelimiterIsNotConsistent() {
        String input = "//|\n1|2,3";
        assertThat(sc.add(input)).isEqualTo("'|' expected but ',' found at position 3.");
    }
}
