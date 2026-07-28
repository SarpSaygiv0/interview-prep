package com.easy.binarysearch;

public class BinarySearch {


    public int binarySearch(int[] array, int target) {

        int right = array.length - 1;
        int left = 0;

        while (left <= right) {
            int midIndex = (left + right) / 2;
            if (array[midIndex] > target) {
                right = midIndex - 1;
            } else if (array[midIndex] < target) {
                left = midIndex + 1;
            } else {
                return midIndex;
            }
        }

        return -1;
    }
}
