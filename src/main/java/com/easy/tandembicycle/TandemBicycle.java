package com.easy.tandembicycle;

import java.util.Arrays;

public class TandemBicycle {

    public int tandemBicycle(
            int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest
    ) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int sum = 0;
        for (int i = 0; i <redShirtSpeeds.length; i++) {
            int j = fastest ? redShirtSpeeds.length - 1 - i : i;
            sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[j]);
        }
        return sum;
    }
}
