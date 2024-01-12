package com.dp.bagProblem.zeroOne;

//416. Partition Equal Subset Sum
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;

        int size = sum / 2;
        int[] dp = new int[size + 1];
        for (int i = 0; i < n; i++) {
            for (int j = size; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            if (dp[size] == size) return true;
        }
        return dp[size] == size;
    }
}
