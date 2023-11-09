package com.array;

/**
 * 删除有序数组中的重复项 lc 26 lc 80
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[r] != nums[i]) {
                nums[++r] = nums[i];
            }
        }
        return r + 1;
    }

    public int removeDuplicates2(int[] nums) {
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[r] != nums[i]) {
                nums[++r] = nums[i];
            } else if (r > 0 && nums[r - 1] != nums[r] || r == 0) {
                nums[++r] = nums[i];
            }
        }
        return r + 1;
    }
}
