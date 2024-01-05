package com.greedy;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            } else {
                break;
            }
        }
        if (i > 0) Arrays.sort(nums);
        if (k % 2 == 1) nums[0] = -nums[0];
        int sum = 0;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
