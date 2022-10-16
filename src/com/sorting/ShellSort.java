package com.sorting;

/**
 * Created by major on 16/5/5.
 */
public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        if(A == null || n < 2) {
            return A;
        }
        int feet = A.length / 2;
        int index = 0;
        while(feet > 0) {
            for(int i=feet;i<A.length;i++) {
                index = i;
                while(index >= feet) {
                    if (A[index - feet] > A[index]) {
                        Tool.swap(A, index - feet, index);
                        index -= feet;
                    } else {
                        break;
                    }
                }
            }
            feet = feet / 2;
        }
        return A;
    }

}
