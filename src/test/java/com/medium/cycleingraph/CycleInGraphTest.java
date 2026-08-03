package com.medium.cycleingraph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CycleInGraphTest {

    CycleInGraph cig;

    @BeforeEach
    void setCig() {
        cig = new CycleInGraph();
    }

    @Test
    void cycleInGraphTest() {
        int[][] input = new int[][]{{1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {}};
        assertThat(cig.cycleInGraph(input)).isEqualTo(true);
    }
}
