package com.array;

/**
 * 数组中未出现的最小正整数
 */
public class MissNum {
    public int missNum(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
                arr[l] = arr[--r];
            } else {
                swap(arr, arr[l] - 1, l);
            }
        }
        return l + 1;
    }

    public void swap(int[] arr, int a, int b){

    }
}
