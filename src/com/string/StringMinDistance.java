package com.string;

/**
 * 数组中两个字符串的最小距离 pg 266
 */
public class StringMinDistance {
    public int minDistance(String[] strs, String str1, String str2) {
        if (strs == null || str1 == null || str2 == null || strs.length == 0) {
            return -1;
        }
        int last1 = -1;
        int last2 = -1;
        int min = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str1)) {
                if (last2 >= 0) {
                    min = Math.min(min, i - last2);
                }
                last1 = i;
            } else if (strs[i].equals(str2)) {
                if (last1 >= 0) {
                    min = Math.min(min, i - last1);
                }
                last2 = i;
            }
        }
        return min;
    }
}
