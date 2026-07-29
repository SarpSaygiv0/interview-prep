package com.medium.smallestdifference;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SmallestDifferenceTest {

    SmallestDifference sd;

    @BeforeEach
    void setSd() {
        sd = new SmallestDifference();
    }

    @Test
    void testSmallestDifference() {
        int[] expected = {28, 26};
        assertArrayEquals(sd.smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17}),
                expected
        );
    }
}
