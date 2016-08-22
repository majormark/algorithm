package com.sorting;

/**
 * Created by major on 16/5/12.
 */
public class Tool {
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
