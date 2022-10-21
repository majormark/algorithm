package com.array;

/**
 * 计算数组的小和
 */
public class SmallSum {
    public int getSmallSum(int[] arr) {
        return merge(arr, 0, arr.length - 1);
    }

    public int merge(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int lSum = merge(arr, left, mid);
        int rSum = merge(arr, mid+1, right);
        int[] help = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        int sum = 0;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sum += arr[l] * (right - r + 1);
                help[index++] = arr[l++];
            } else {
                help[index++] = arr[r++];
            }
        }
        while (l <= mid) {
            help[index++] = arr[l++];
        }
        while (r <= right) {
            help[index++] = arr[r++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
        return lSum + rSum + sum;
    }
}
