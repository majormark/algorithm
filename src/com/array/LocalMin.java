package com.array;

/**
 * 在数组中找到一个局部最小的位置 pg.371
 */
public class LocalMin {
    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        int n = arr.length;
        if (arr[n-2] > arr[n-1]) {
            return n-1;
        }
        int left = 1;
        int right = n-2;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
