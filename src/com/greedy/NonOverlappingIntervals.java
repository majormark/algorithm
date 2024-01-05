package com.greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int count = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (left <= intervals[i][0] && intervals[i][0] < right) {
                count++;
                if (intervals[i][1] <=right) {
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}}));
    }
}
