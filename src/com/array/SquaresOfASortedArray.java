package com.array;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] newArr = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int idx = nums.length - 1;
        while (l <= r) {
            int res = 0;
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res =  nums[l] * nums[l];
                l++;
            } else {
                res = nums[r] * nums[r];
                r--;
            }
            newArr[idx--] =  res;
        }
        return newArr;
    }
}
