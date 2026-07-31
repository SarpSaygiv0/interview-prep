package com.medium.mergeoverlappingintervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeOverlappingIntervalsTest {

    MergeOverlappingIntervals moi;

    @BeforeEach
    void setMoi() {
        moi = new MergeOverlappingIntervals();
    }

    @Test
    void merveOverlappingIntervalsTest() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        int[][] expected = new int[][]{{1, 2}, {3, 8}, {9, 10}};
        int[][] actual = moi.mergeOverlappingIntervals(intervals);
        assertThat(actual).isEqualTo(expected);
    }
}
