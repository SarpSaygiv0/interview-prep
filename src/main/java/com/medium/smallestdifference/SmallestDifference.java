package com.medium.smallestdifference;

import java.util.Arrays;

public class SmallestDifference {

    public int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        /*
        [-1, 5, 10, 20, 28, 3] -> -1 3 5 10 20 28
        [26, 134, 135, 15, 17] -> 15 17 26 134 135
         */
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int arrOneIndex = 0;
        int arrTwoIndex = 0;
        int diff = Integer.MAX_VALUE;
        int[] result = {0, 0};
        while (arrOneIndex < arrayOne.length && arrTwoIndex < arrayTwo.length) {
            int currDiff = Math.abs(arrayOne[arrOneIndex] - arrayTwo[arrTwoIndex]);
            if (currDiff < diff) {
                diff = currDiff;
                result[0] = arrayOne[arrOneIndex];
                result[1] = arrayTwo[arrTwoIndex];
            }
            if (arrayOne[arrOneIndex] == arrayTwo[arrTwoIndex])
                return result;
            else if (arrayOne[arrOneIndex] < arrayTwo[arrTwoIndex])
                arrOneIndex++;
            else
                arrTwoIndex++;
        }
        return result;
    }
}
