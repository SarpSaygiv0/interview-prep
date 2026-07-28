package com.easy.bubblesort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {

    BubbleSort bs;

    @BeforeEach
    void setBs() {
        bs = new BubbleSort();
    }

    @Test
    void bubbleSortTest() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        assertArrayEquals(bs.bubbleSort(input), expected);
    }
}
