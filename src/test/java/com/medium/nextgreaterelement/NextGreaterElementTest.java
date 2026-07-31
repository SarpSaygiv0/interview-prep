package com.medium.nextgreaterelement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NextGreaterElementTest {
    NextGreaterElement nge;

    @BeforeEach
    void setNge() {
        nge = new NextGreaterElement();
    }

    @Test
    void testNextGreaterElement() {
        int[] input = new int[]{2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[]{5, 6, 6, 6, 7, -1, 5};
        int[] actual = nge.nextGreaterElement(input);
        assertThat(actual).isEqualTo(expected);
    }
}
