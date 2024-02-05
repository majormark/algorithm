package com.other;
//31. Next Permutation
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 1. a[i] < a[j]  <-
        // 2. for j - > end  find a[i] < a[k]
        // 3. swap i k, j - > end 降序，调整为升序
        // 4. 如果1找不到，整体调整为升序
        if (nums.length <= 1) return;
        int n = nums.length;
        int i = 0;
        for (int j = n - 1; j > 0; j--) {
            i = j - 1;
            if ( nums[i] < nums[j]) break;
        }
        if (nums[i] < nums[i+1]) {
            int k = i + 1;
            for (int j = i + 2; j < n; j++) {
                if (nums[j] > nums[i]) k = j;
                else break;
            }
            swap(nums, i, k);
            asc(nums, i + 1);
        } else {
            asc(nums, 0);
        }
    }

    public void asc(int[] nums, int st) {
        int r = nums.length - 1;
        int l = st;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
