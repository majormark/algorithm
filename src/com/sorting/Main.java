package com.sorting;

import com.sortingSpecial.Checker;

import java.util.Arrays;

/**
 * Created by major on 16/5/4.
 */
public class Main {
    public static void main(String[] args) {
        int[] A = {227,123,278,38,242,229,202,269,76,197,12,32,235,23,266,124,253,179,216,250,123,106,284,250,44,225,36,25,144,123,264,70,287,244,123,89,21,258,203,97,188,295,211,302,177,80,258,267,164,58,0,76,63,222,6,114,5,128,256,173,191,157,50,181,152,18,302,135,108};
        //int[] result = new BubbleSort().bubbleSort(A, A.length);
        //int[] result = new SelectionSort().selectionSort(A, A.length);
        //int[] result = new InsertionSort().insertionSort(A, A.length);
        //int[] result = new ShellSort().shellSort(A, A.length);
        //int[] result = new MergeSort().mergeSort(A, A.length);
        //int[] result = new QuickSort().quickSort(A, A.length);
        //int[] result = new HeapSort().heapSort(A, A.length);
        //int[] result = new CountingSort().countingSort(A, A.length);
        int[] result = new RadixSort().radixSort(A, A.length);
        //System.out.print(Arrays.toString(result));


    }
}
