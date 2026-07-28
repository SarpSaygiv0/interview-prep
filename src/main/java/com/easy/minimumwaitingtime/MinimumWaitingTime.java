package com.easy.minimumwaitingtime;

import java.util.Arrays;

public class MinimumWaitingTime {


    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int waitingTime = 0;
        int totalTime = 0;
        for (int i = 0; i < queries.length-1; i++) {
            int currentTime = queries[i];
            waitingTime = waitingTime + currentTime;
            totalTime += waitingTime;
        }
        return totalTime;
    }
}
