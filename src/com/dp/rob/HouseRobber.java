package com.dp.rob;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    // 213. House Robber II
    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] a = new int[nums.length - 1];
        int[] b = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            a[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            b[i - 1] = nums[i];
        }
        return Math.max(rob(a), rob(b));
    }

}
