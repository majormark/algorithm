package com.array;

import java.util.HashMap;

/**
 * book pg.355
 * 未排序数组中累加和为给定值的最长子数组系列
 */
public class InOrderArrayMaxLength {
    public int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        int len = 0;
        int sum = 0;
        m.put(0, -1);
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
            if (m.containsKey(sum-k)) {
                int idx = m.get(sum-k);
                len = Math.max(i - idx + 1, len);
            }
            if (!m.containsKey(sum)) {
                m.put(sum, i);
            }
        }
        return len;
    }
}
