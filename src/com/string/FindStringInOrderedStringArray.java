package com.string;

/**
 * 在有序但含有空的数组中查找字符串 pg 258
 */
public class FindStringInOrderedStringArray {
    public int getIndex(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) {
            return -1;
        }
        int left = 0;
        int right = strs.length - 1;
        int res = -1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                int i = mid;
                while (strs[i] == null && --i >= left);
                if (i < left || strs[i].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    right = i - 1;
                    res = strs[i].equals(str) ? i : res;
                }
            }
        }
        return res;
    }
}
