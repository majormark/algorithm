package com.string;

/**
 * 判断字符数组中是否所有的字符都只出现一次
 */
public class Unique {
    public boolean isUniq1(char[] ch) {
        if (ch == null || ch.length == 0) {
            return false;
        }
        boolean[] m = new boolean[256];
        for (int i=0;i<ch.length;i++) {
            if (m[ch[i]]) {
                return false;
            }
            m[ch[i]] = true;
        }
        return true;
    }

    public boolean isUniq2(char[] ch) {
        if (ch == null || ch.length == 0) {
            return false;
        }
        ch = heapSort(ch);
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i+1]) {
                return false;
            }
        }
        return true;
    }

    public char[] heapSort(char[] arr) {
        int n = arr.length;
        buildHeap(arr);
        for (int i=n-1;i>=0;i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
        return arr;
    }
    public void swap(char[] arr, int i, int j) {
        char a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }
    public void buildHeap(char[] arr) {
        int n = arr.length;
        for (int i = (n - 1) / 2;i>=0;i--) {
            heapAdjust(arr, i, n);
        }
    }
    public void heapAdjust(char[] arr, int index, int length) {
        char tmp = arr[index];
        int child;
        for (;index * 2 + 1 < length;index = child) {
            child = index * 2 + 1;
            if (child != length - 1 && arr[child + 1] > arr[child]) child++;
            if (arr[index] < arr[child]) {
                arr[index] = arr[child];
            } else {
                break;
            }
        }
        arr[index] = tmp;
    }

}
