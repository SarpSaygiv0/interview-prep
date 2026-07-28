package com.easy.tandembicycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TandemBicycleTest {

    TandemBicycle tb;

    @BeforeEach
    void setTb() {
        tb = new TandemBicycle();
    }

    @Test
    public void TestCase1() {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;
        var actual = tb.tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        boolean fastest = false;
        int expected = 25;
        var actual = tb.tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        assertTrue(expected == actual);
    }

}
