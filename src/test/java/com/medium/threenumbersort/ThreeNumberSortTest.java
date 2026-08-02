package com.medium.threenumbersort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeNumberSortTest {


    ThreeNumberSort tns;

    @BeforeEach
    void setTns() {
        tns = new ThreeNumberSort();
    }

    @Test
    void threeNumberSortTest() {
        int[] input = {1, 3, 3, -1, -1, 3, 1, 1};
        int[] order = {3, 1, -1};
        int[] expected = {3, 3, 3, 1, 1, 1, -1, -1};
        assertThat(tns.threeNumberSort(input, order)).isEqualTo(expected);
    }

    @Test
    void threeNumberSortTestWithTwoNumbers() {
        int[] input = {1, -1, 1, -1, -1, 1, 1, 1};
        int[] order = {1, 3, -1};
        int[] expected = {1, 1, 1, 1, 1, -1, -1, -1};
        assertThat(tns.threeNumberSort(input, order)).isEqualTo(expected);
    }

    @Test
    void threeNumberSortDijkstraTest() {
        int[] input = {1, 3, 3, -1, -1, 3, 1, 1};
        int[] order = {3, 1, -1};
        int[] expected = {3, 3, 3, 1, 1, 1, -1, -1};
        assertThat(tns.threeNumberSortDijkstra(input, order)).isEqualTo(expected);
    }

    @Test
    void threeNumberSortDijkstraTestWithTwoNumbers() {
        int[] input = {1, -1, 1, -1, -1, 1, 1, 1};
        int[] order = {1, 3, -1};
        int[] expected = {1, 1, 1, 1, 1, -1, -1, -1};
        assertThat(tns.threeNumberSortDijkstra(input, order)).isEqualTo(expected);
    }
}
