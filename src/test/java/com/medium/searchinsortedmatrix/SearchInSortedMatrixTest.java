package com.medium.searchinsortedmatrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInSortedMatrixTest {

    SearchInSortedMatrix sism;

    @BeforeEach
    void setSism() {
        sism = new SearchInSortedMatrix();
    }

    @Test
    void bsTest() {
        int[] input = {1, 4, 7, 12, 15, 1000};
        int target = 12;
        assertThat(sism.binarySearch(input, target)).isEqualTo(3);
    }

    @Test
    void searchInSortedMatrixTest() {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        int[] expected = {3, 3};
        assertThat(sism.searchInSortedMatrix(matrix, 44)).isEqualTo(expected);
    }

    @Test
    void searchInSortedMatrixWithoutBsTest() {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        int[] expected = {3, 3};
        assertThat(sism.searchInSortedMatrixWithoutBs(matrix, 44)).isEqualTo(expected);
    }
}
