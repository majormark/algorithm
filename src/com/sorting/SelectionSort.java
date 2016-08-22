package com.sorting;

/**
 * Created by major on 16/5/4.
 */
public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {

        for(int i=0;i<n;i++) {
            int max=0;
            int j=0;
            for(;j<n-i;j++) {
                if(A[j] > A[max]) {
                    max = j;
                }
            }
            Tool.swap(A, max, j-1);
        }

        return A;
    }

}
