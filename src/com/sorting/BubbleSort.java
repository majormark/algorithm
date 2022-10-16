package com.sorting;

/**
 * Created by major on 16/5/4.
 */
public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
        // write code here
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(A[j] > A[j+1])
                    Tool.swap(A, j, j+1);
            }
        }
        return A;
    }

}
