package com.sorting;

/**
 * Created by major on 16/5/5.
 */
public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        process(A, 0, A.length - 1);
        return A;
    }

    public void process(int[] A, int left, int right) {
        if(left < right) {
            int mid = partition(A, left, right);
            process(A, left, mid - 1);
            process(A, mid + 1, right);

        }
    }
    public int partition(int[] A, int left, int right) {
        int pivot = A[left];
        while (left < right) {
            while (left < right && A[right] >= pivot) --right;
            Tool.swap(A, left, right);
            while (left < right && A[left] <= pivot) ++left;
            Tool.swap(A, left, right);
        }
        return left;
    }

    public static int first, last;

    public static void partition2(int[] arr, int left, int right, int x) {
        int i = left;
        first = left;
        last = right;
        while (i <= last) {
            if (arr[i] < x) {
                swap(arr, i++, first++);
            } else if (arr[i] == x) {
                i++;
            } else  {
                swap(arr, i, last--);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
