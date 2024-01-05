package com.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    //56. Merge Intervals
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= right) right = Math.max(right, intervals[i][1]);
            else {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left, right});

        return list.toArray(new int[list.size()][]);
    }
}
