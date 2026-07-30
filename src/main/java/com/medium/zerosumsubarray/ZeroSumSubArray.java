package com.medium.zerosumsubarray;

import java.util.HashSet;

public class ZeroSumSubArray {


    public boolean zeroSumSubarray(int[] nums) {
        /*
          [-5, -5, 2, 3, -2]
          i = 5 (-5) + (-5) + 2 + 3 + (-2) = -7
          i = 4 (-5) + (-5) + 2 + 3 = -5
          i = 3 (-5) + (-5) + 2 = -8
          i = 2 (-5) + (-5) = -10
          i = 1 (-5) = -5

        */
        HashSet<Integer> tracker = new HashSet<>();
        int sum = 0;
        tracker.add(sum);
        for (int num : nums) {
            sum += num;
            if (tracker.contains(sum))
                return true;
            tracker.add(sum);
        }
        return false;

    }
}
