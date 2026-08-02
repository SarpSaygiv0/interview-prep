package com.medium.threenumbersort;

import java.util.HashMap;
import java.util.Map;

public class ThreeNumberSort {

    public int[] threeNumberSort(int[] arr, int[] order) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int value : arr) {
            count.put(value, count.getOrDefault(value, 0) + 1);
        }
        int startingIndex = 0;
        int length = 0;
        for (int j : order) {
            length += count.getOrDefault(j, 0);
            for (; startingIndex < length; startingIndex++) {
                arr[startingIndex] = j;
            }
        }

        return arr;
    }
}
