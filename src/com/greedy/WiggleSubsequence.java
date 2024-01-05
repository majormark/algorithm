package com.greedy;

import java.util.Arrays;

//376. Wiggle Subsequence
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int preDiff = 0;
        int curDiff = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

    // 动态规划
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // 0 波峰最大长度
        // 1 波谷最大长度
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[j][0] + 1, dp[i][1]);
                }
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[j][1] + 1, dp[i][0]);
                }
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    // 动态规划优化
    // https://leetcode.cn/problems/wiggle-subsequence/solutions/284327/tan-xin-si-lu-qing-xi-er-zheng-que-de-ti-jie-by-lg
    public int wiggleMaxLength3(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
