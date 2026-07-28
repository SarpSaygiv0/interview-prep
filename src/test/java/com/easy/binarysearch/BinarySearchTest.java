package com.easy.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    BinarySearch bs;

    @BeforeEach
    void setBs() {
        bs = new BinarySearch();
    }

    @Test
    void binarySearchTest() {
        int[] arr = new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        assertEquals(3, bs.binarySearch(arr, target));
    }

    @Test
    void binarySearchTest2() {
        int[] arr = new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 73;
        assertEquals(9, bs.binarySearch(arr, target));
    }

    @Test
    void binarySearchTest3() {
        int[] arr = new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 0;
        assertEquals(0, bs.binarySearch(arr, target));
    }
}
