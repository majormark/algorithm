package com.dp.bagProblem.complete;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> nums = new LinkedList<>();
        int idx = 1;
        while (idx * idx <= n) {
            nums.add(idx * idx);
            idx++;
        }
        Integer[] arr = nums.toArray(new Integer[0]);
        int[] dp = new int[n + 1];
        int MAX = Integer.MAX_VALUE;
        Arrays.fill(dp, 1, dp.length, MAX);
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < n + 1; j++) {
                if (dp[j - arr[i]] != MAX) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        return dp[n];
    }
}
