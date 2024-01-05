package com.greedy;

public class MaximumSubarray {

    // 动态规划优化
    public int maxSubArray(int[] nums) {
        int preMaxSum = nums[0];
        int max = preMaxSum;
        for (int i = 1; i < nums.length; i++) {
            preMaxSum = Math.max(preMaxSum + nums[i], nums[i]);
            max = Math.max(preMaxSum, max);
        }
        return max;
    }

    // 贪心
    public int maxSubArray2(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
             if (sum > res) res = sum;
             if (sum < 0) sum = 0;
        }
        return res;
    }
}
