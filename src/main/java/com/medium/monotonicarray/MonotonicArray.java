package com.medium.monotonicarray;

public class MonotonicArray {

    // [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
    // 3, 4 -> 4 - 3 = 1 (+), 4, 3 -> 3 - 4 = -1 (-)
    public boolean isMonotonic(int[] arr) {
        if (arr.length <= 2)
            return true;

        int direction = arr[1] - arr[0];
        for (int i = 1; i <arr.length; i++) {
            if (direction == 0) {
                direction = arr[i] - arr[i - 1];
                continue;
            }
            if (breaksMonotic(direction, arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean breaksMonotic(int direction, int current, int prev) {
        int difference = current - prev;
        if (direction > 0)
            return difference < 0;
        return difference > 0;
    }

    public boolean isMonotonicSimple(int[] arr) {
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i + 1])
                isNonDecreasing = false;
            if (arr[i] > arr[i + 1])
                isNonIncreasing = false;
        }

        return isNonDecreasing || isNonIncreasing;
    }
}
