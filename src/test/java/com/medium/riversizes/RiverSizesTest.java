package com.medium.riversizes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RiverSizesTest {

    RiverSizes rs;

    @BeforeEach
    void setRs() {
        rs = new RiverSizes();
    }

    @Test
    void testRiverSizes() {
        int[][] input = new int[][]{
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1},
        };
        int[][] expected = new int[][]{
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1},
        };
        assertThat(rs.removeIslands(input)).isDeepEqualTo(expected);
    }
}
