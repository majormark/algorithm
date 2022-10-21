package com.array;

import java.util.HashSet;

/**
 * 最长可整合子数组
 */
public class LongestIntegratedSubArray {
    public int getLIL(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) {
                    len = Math.max(max - min + 1, len);
                }
            }
            set.clear();
        }
        return len;
    }
}
