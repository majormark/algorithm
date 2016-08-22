package com.sorting;

/**
 * Created by major on 16/5/5.
 */
public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        if(A == null || n<2)
            return A;
        process(A, 0, A.length-1);
        return A;
    }

    public static void process(int[] A, int left, int right) {
        if(left == right)
            return;
        int mid = (left + right) / 2;
        process(A, left, mid);
        process(A, mid+1, right);
        merge(A, left, mid, right);
    }
    public static void merge(int[] A, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int index = 0;
        int l = left;
        int r = mid+1;
        while(l <= mid && r <= right) {
            if(A[l] <= A[r]) {
                help[index++] = A[l++];
            } else {
                help[index++] = A[r++];
            }
        }
        while(l <= mid) {
            help[index++] = A[l++];
        }
        while(r <= right) {
            help[index++] = A[r++];
        }
        for(int i=0;i<help.length;i++) {
            A[left + i] = help[i];
        }
    }
}
