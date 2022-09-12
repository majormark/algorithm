package com.dp;

import java.util.HashMap;

public class LongestConsecutive {
    public int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            if (!m.containsKey(arr[i])) {
                m.put(arr[i], 1);
            }
            if (m.containsKey(arr[i] - 1)) {
                max = Math.max(max, merge(m, arr[i]-1, arr[i]));
            }
            if (m.containsKey(arr[i] + 1)) {
                max = Math.max(max, merge(m, arr[i], arr[i] + 1));
            }
        }
        return max;
    }

    public int merge(HashMap<Integer, Integer> m, int less, int more) {
        int left = less - m.get(less) + 1;
        int right = more + m.get(more) - 1;
        int len = right - less + 1;
        m.put(left, len);
        m.put(right, len);
        return len;
    }
}
