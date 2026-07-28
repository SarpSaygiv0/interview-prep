package com.easy.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int remainder = target - current;
            if (bucket.containsKey(remainder)) {
                int indexOfRemainder = bucket.get(remainder);
                return new int[] {current, arr[indexOfRemainder]};
            }
            bucket.put(current, i);
        }
        return new int[] {};
    }
}
