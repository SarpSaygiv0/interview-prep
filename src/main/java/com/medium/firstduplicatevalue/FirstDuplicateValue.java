package com.medium.firstduplicatevalue;


import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue {

    public int firstDuplicateValueNaive(int[] arr) {
        Set<Integer> tracker = new HashSet<>();
        for (int i : arr) {
            if (tracker.contains(i)) {
                return i;
            }
            tracker.add(i);
        }
        return -1;
    }

    // reiterate
    public int firstDuplicateValue(int[] arr) {
        for (int value: arr) {
            int absValue = Math.abs(value);
            if (arr[absValue - 1] < 0)
                return absValue;
            arr[absValue - 1] *= -1;
        }
        return -1;
    }
}
