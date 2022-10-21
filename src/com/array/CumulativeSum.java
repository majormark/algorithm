package com.array;

/**
 * 子数组最大累加和
 */
public class CumulativeSum {
    public int maxSum(int[] arr) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur >= 0) {
                max = Math.max(max, cur);
            } else {
                cur = 0;
            }
        }
        return max;
    }
}
