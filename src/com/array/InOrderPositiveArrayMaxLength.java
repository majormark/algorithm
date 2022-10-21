package com.array;

/**
 * 未排序正数数组累加和为给定值的最长子数组
 */
public class InOrderPositiveArrayMaxLength {
    public int getMaxLength(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int sum = arr[0];
        int len = 0;
        while (r < arr.length) {
            if (sum == k) {
                len = Math.max(r - l + 1, len);
                sum -= arr[l];
                l++;
            } else if (sum > k) {
                r++;
                if (r == arr.length) {
                    break;
                }
                sum += arr[r];
            } else {
                l++;
            }
        }
        return len;
    }
}
