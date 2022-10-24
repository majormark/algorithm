package com.array;

/**
 * 数组的partition调整
 */
public class PartitionAdjust {
    public void leftUnique(int[] arr) {
        int l = 0;
        int r = 1;
        while (r < arr.length) {
            if (arr[l] != arr[r++]) {
                swap(arr, ++l, r-1);
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public void sort(int[] arr) {
        int left = -1;
        int index = 0;
        int right = arr.length;
        while (index < right) {
            if (arr[index] == 1) {
                index++;
            } else if (arr[index] == 0) {
                swap(arr, ++left, index);
            } else {
                swap(arr, index, --right);
            }
        }
    }
}
