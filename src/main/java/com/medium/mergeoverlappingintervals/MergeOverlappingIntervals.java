package com.medium.mergeoverlappingintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> output = new ArrayList<>();
        int[] maxInterval = intervals[0];
        output.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (maxInterval[1] >= intervals[i][0]) {
                maxInterval[1] = Math.max(maxInterval[1], intervals[i][1]);
            } else {
                maxInterval = intervals[i];
                output.add(maxInterval);
            }
        }

        return output.toArray(new int[output.size()][]);
    }
}













