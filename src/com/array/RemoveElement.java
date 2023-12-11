package com.array;

// 27. Remove Element
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int end = nums.length - 1;
        int st = 0;
        while (st <= end) {
            if (nums[st] == val) {
                nums[st] = nums[end--];
                continue;
            }
            st++;
        }
        return st;
    }
}
