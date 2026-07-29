package com.medium.zerosumsubarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZeroSumSubArrayTest {

    ZeroSumSubArray zssa;

    @BeforeEach
    void setZssa() {
        zssa = new ZeroSumSubArray();
    }

    @Test
    void zeroSumSubArrayTest() {
        int[] input = {-5, -5, 2, 3, -2};
        assertTrue(zssa.zeroSumSubarray(input));
    }

    @Test
    void zeroSumSubArrayTest2() {
        int[] input = {4, -3, 2, 4, -1, -5, 7};
        assertTrue(zssa.zeroSumSubarray(input));
    }
}
