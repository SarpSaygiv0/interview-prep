package com.medium.monotonicarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonotonicArrayTest {
    MonotonicArray ma;

    @BeforeEach
    void setMa() {
        ma = new MonotonicArray();
    }

    @Test
    void isMonotonicTest(){
        int[] input = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        assertTrue(ma.isMonotonic(input));
    }

    @Test
    void isMonotonicSimpleTest(){
        int[] input = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        assertTrue(ma.isMonotonicSimple(input));
    }
}
