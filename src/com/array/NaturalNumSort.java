package com.array;

/**
 * 自然数数组的排序
 */
public class NaturalNumSort {
    public void sort1(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                tmp = arr[i];
                arr[i] = arr[tmp - 1];
                arr[tmp - 1] = tmp;
            }
        }
    }
}
