package com.medium.searchinsortedmatrix;

public class SearchInSortedMatrix {

    public int[] searchInSortedMatrix(int[][] matrix, int target) {

        for (int row = 0; row < matrix.length; row++) {
            int searchResult = binarySearch(matrix[row], target);
            if (searchResult != -1) {
                return new int[]{row, searchResult};
            }
        }

        return new int[]{-1, -1};
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int[] searchInSortedMatrixWithoutBs(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int column = 0;

        while (column <= matrix.length && row >= 0) {
            if (target < matrix[row][column])
                row--;
            else if (target > matrix[row][column])
                column++;
            else
                return new int[]{row, column};
        }
        return new int[]{-1, -1};
    }
}
