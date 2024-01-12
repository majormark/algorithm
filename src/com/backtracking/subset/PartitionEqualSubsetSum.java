package com.backtracking.subset;

import java.util.Arrays;

// 416. Partition Equal Subset Sum
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        Arrays.sort(nums);
        return backtrack(nums, 0, sum / 2);
    }

    public boolean backtrack(int[] arr, int start, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0) return false;
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i-1] == arr[i]) continue;
            if (backtrack(arr, i + 1, target - arr[i])) {
                return true;
            }
        }
        return false;
    }
}
