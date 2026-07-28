package com.medium.threesum;

import java.util.*;

public class ThreeSum {

    // [12, 3, 1, 2, -6, 5, -8, 6], target = 0
    // a + b + c = x
    // x - a = b + c
    // i 0  a = 12 -> target - a = 12
    //       twoSum(b = 3 c = 1 newTarget = 12)
    // find indexes that sums up to newTarget from remaining list
    // when found add to result list
    // start by sorting the array

    public List<Integer[]> threeSum(int[] arr, int target) {
        List<Integer[]> result = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i <arr.length-2; i++) {
            int newTarget = target - arr[i];
            for (int j = i+1; j < arr.length; j++) {
                int current = arr[j];
                int remainder = newTarget - current;
                if (counter.containsKey(remainder)) {
                    int idx = counter.get(remainder);
                    Integer[] ints = {arr[i], current, arr[idx]};
                    Arrays.sort(ints);
                    result.add(ints);
                }
                counter.put(current, j);
            }
            counter.clear();
        }
        result.sort(Comparator.comparingInt((Integer[] list) -> list[0]).
                thenComparingInt(list -> list[1]).
                thenComparingInt(list -> list[2]));
        return result;
    }

    public List<Integer[]> threeSumPointers(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i<arr.length-2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum == target) {
                    Integer[] triplet = {arr[i], arr[left], arr[right]};
                    result.add(triplet);
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
