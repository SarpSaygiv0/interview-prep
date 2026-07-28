package com.easy.minimumwaitingtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MinimumWaitingTimeTest {

    MinimumWaitingTime mwt;

    @BeforeEach
    void setMwt() {
        mwt = new MinimumWaitingTime();
    }
    @Test
    public void TestCase1() {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int actual = mwt.minimumWaitingTime(queries);
        assertEquals(17, actual);
    }
}
