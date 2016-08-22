package com.sorting;

/**
 * Created by major on 16/5/12.
 */
public class HeapSort {

    public int[] heapSort(int[] A, int n) {
        buildHeap(A, n);
        for(int i=n-1;i>0;i--) {
            Tool.swap(A, 0, i);
            heapAjust(A, 0, i);
        }
        return A;
    }
    public void heapAjust(int[] A, int index, int length) {
        int temp = A[index];
        int child ;
        for(;(index * 2 + 1) < length;index = child) {
            child = 2 * index + 1;
            if(child != length - 1 && A[child + 1] > A[child])
                child++;
            if(A[child] > temp) {
                A[index] = A[child];
            } else {
                break;
            }
        }
        A[index] = temp;
    }

    public void buildHeap(int[] A, int n) {
        for(int i=(n - 1) / 2;i>=0;i--) {
            heapAjust(A, i, n);
        }
    }
}


