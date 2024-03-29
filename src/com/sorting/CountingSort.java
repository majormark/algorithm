package com.sorting;

/**
 * Created by major on 16/5/13.
 */
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        // write code here
        int min = A[0];
        int max = A[0];
        for(int i=1;i<n;i++) {
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }
        int[] countArr = new int[max - min + 1];
        for(int i=0;i<n;i++) {
            countArr[A[i] - min]++;
        }
        int index = 0;
        for(int i=0;i<countArr.length;i++) {
            while (countArr[i]-- > 0) {
                A[index++] = i + min;
            }
        }
        return A;
    }

    public int[] count(int[] arr, int n) {
        int min = arr[0];
        int max = arr[0];
        for (int i=1;i<n;i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        int[] count = new int[max - min + 1];
        for (int i=0;i<n;i++) {
            count[arr[i] - min]++;
        }
        int index = 0;
        for (int i=0;i<count.length;i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
        return arr;
    }
}
