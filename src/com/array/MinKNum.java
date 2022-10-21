package com.array;

public class MinKNum {
    public int[] getMinKNumByHeap(int[] arr, int k) {
        int[] heapK = new int[k];
        buildHeap(arr, heapK, k);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heapK[0]) {
                heapK[0] = arr[i];
                heapAdjust(heapK, 0, k);
            }
        }
        return heapK;
    }

    public void heapAdjust(int[] arr, int index, int length) {
        int tmp = arr[index];
        int child;
        for (;index < length;index = child) {
            child = index * 2 + 1;
            if (child < length - 1 && arr[child + 1] > arr[child]) child++;
            if (arr[index] < arr[child]) {
                arr[index] = arr[child];
            } else {
                break;
            }
            arr[index] = tmp;
        }
    }

    public void buildHeap(int[] arr, int[] heapK, int k) {
        for (int i=0;i<k;i++) {
            heapK[i] = arr[i];
        }
        for (int i = (k-1)/2;i>=0;i--) {
            heapAdjust(heapK, i, k);
        }
    }
}
