package com.easy.twosum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {

    TwoSum ts;
    @BeforeEach
    void setTs() {
        ts = new TwoSum();
    }

    @Test
    void twoSum() {
        int[] arr = new int[] {3, 5, -4, 8, 11, 1, -1, 6};
        int target = 10;
        int[] expected = new int[] {-1, 11};
        assertArrayEquals(ts.twoSum(arr, target), expected);
    }
}
