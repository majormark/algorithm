package com.sorting;

/**
 * Created by major on 16/5/5.
 */
public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        int index = 0;

        for(int i=1;i<n;i++) {
            index = i;
            while (index > 0) {
                if(A[index - 1] > A[index]) {
                    Tool.swap(A, index - 1, index);
                    index--;
                } else {
                    break;
                }
            }
        }
        return A;
    }


}
