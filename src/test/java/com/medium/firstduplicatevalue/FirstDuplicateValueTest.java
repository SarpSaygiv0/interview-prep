package com.medium.firstduplicatevalue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstDuplicateValueTest {

    FirstDuplicateValue fdv;

    @BeforeEach
    void setFdv() {
        fdv = new FirstDuplicateValue();
    }

    @Test
    void firstDuplicateValueTest() {
        int[] input = {2, 1, 5, 2, 3, 3, 4};
        int expected = 2;
        assertThat(fdv.firstDuplicateValue(input)).isEqualTo(expected);
    }

    @Test
    void firstDuplicateValueTest2() {
        int[] input = {2, 1, 5, 3, 3, 2, 4};
        int expected = 3;
        assertThat(fdv.firstDuplicateValue(input)).isEqualTo(expected);
    }

    @Test
    void firstDuplicateValueNaiveTest() {
        int[] input = {2, 1, 5, 3, 3, 2, 4};
        int expected = 3;
        assertThat(fdv.firstDuplicateValueNaive(input)).isEqualTo(expected);
    }
}
