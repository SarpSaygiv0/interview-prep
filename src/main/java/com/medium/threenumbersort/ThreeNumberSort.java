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

    public int[] threeNumberSortDijkstra(int[] arr, int[] order) {
        int firstValue = order[0];
        int secondValue = order[1];

        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = arr.length - 1;

        while (secondIdx <= thirdIdx) {
            int value = arr[secondIdx];
            if (value == firstValue) {
                swap(firstIdx, secondIdx, arr);
                firstIdx++;
                secondIdx++;
            } else if (value == secondValue) {
                secondIdx++;
            } else {
                swap(secondIdx, thirdIdx, arr);
                thirdIdx--;
            }
        }

        return arr;
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
