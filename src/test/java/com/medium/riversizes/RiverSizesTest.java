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
    void riverSizesTest() {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        assertThat(rs.riverSizes(input)).containsExactlyInAnyOrder(1, 2, 2, 2, 5);
    }
}
