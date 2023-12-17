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
        for (; index * 2 + 1< length; index = child) {
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
        for (int i = 0; i < k; i++) {
            heapK[i] = arr[i];
        }
        for (int i = (k - 1) / 2; i >= 0; i--) {
            heapAdjust(heapK, i, k);
        }
    }

    public int[] getMinKNumByHeap2(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(heap, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {
            heap[0] = arr[i];
            heapify(heap, 0, k);
        }
        return heap;
    }

    // 大根堆
    public void heapInsert(int[] heap, int num, int idx) {
        heap[idx] = num;
        while (heap[(idx - 1) / 2] < heap[idx]) {
            swap(heap, (idx - 1) / 2, idx);
            idx = (idx - 1) / 2;
        }
    }

    public void heapify(int[] heap, int idx, int size) {
        int child;
        for (; idx *2+1< size; idx = child) {
            child = idx * 2 + 1;
            if (child < size - 1 && heap[child] < heap[child + 1]) child++;
            if (heap[child] > heap[idx]) {
                swap(heap, child, idx);
            } else {
                break;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
