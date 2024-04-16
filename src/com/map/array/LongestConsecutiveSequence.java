package com.map.array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) continue;
            int tmp = 1;
            int a = nums[i] + 1;
            while (set.contains(a++)) tmp++;
            len = Math.max(tmp, len);
        }
        return len;
    }
}
