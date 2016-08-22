package com.sortingSpecial;

/**
 * Created by major on 16/5/18.
 * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 *
 * 使用堆排,空间复杂度 O(1)
 * 测试样例：
 * [1,2,3,4,5,5,6],7
 * 返回：true
 */
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        if(a == null || n < 2)
            return false;
        heapSort(a, n);
        for(int i=1;i<n;i++) {
            if(a[i-1] == a[i])
                return true;
        }
        return false;
    }

    public void heapSort(int[] a, int n) {
        for(int i=(n-2)/2;i>=0;i--) {//build heap
            heapAjust(a, i, n);
        }
        int index = n-1;
        for(int i=n-1;i>=0;i--) {
            swap(a, 0, i);
            heapAjust(a, 0, i);
        }
    }
    public void heapAjust(int[] a, int index, int len) {
        if(len < 2)
            return ;
        int tmp = a[index];
        int child;
        for(;(index * 2 + 1) < len;index = child) {
            child = index * 2 + 1;
            if(child + 1 < len && a[child] < a[child + 1]) child++;
            if(a[child] > tmp) {
                a[index] = a[child];
            } else {
                break;
            }
        }
        a[index] = tmp;
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
