package com.greedy;

import java.util.Arrays;

//452. Minimum Number of Arrows to Burst Balloons
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) return points.length;
        Arrays.sort(points, (a, b) -> {return a[0]-b[0];});
        int left = points[0][0], right=points[0][1];
        int arrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (left <= points[i][0] && points[i][0] <= right) {
                left = points[i][0];
                right = Math.min(right, points[i][1]);
            } else {
                left = points[i][0];
                right = points[i][1];
                arrows++;
            }
        }
        return arrows;
    }
}
