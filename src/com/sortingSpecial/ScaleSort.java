package com.sortingSpecial;

/**
 * Created by major on 16/5/30.
 */

/**
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
 * 请选择一个合适的排序算法针对这个数据进行排序。
 *  给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 *
 *  测试样例：
 *  [2,1,4,3,6,5,8,7,10,9],10,2
 *
 * 返回：[1,2,3,4,5,6,7,8,9,10]
 */
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        int[] heap = getKHeap(A, k);
        for(int i=k;i<n;i++) {
            A[i-k] = heap[0];
            heap[0] = A[i];
            adjustHeap(heap, 0, k);
        }
        for(int i=n-k;i<n;i++) {
            A[i] = heap[0];
            //heap[0] = A[i];
            swap(heap, 0, k-1);
            adjustHeap(heap, 0, --k);
        }
        return A;
    }

    public int[] getKHeap(int[] A, int k) {
        int[] heap = new int[k];
        for(int i=0;i<k;i++) {
            heapInsert(heap, i, A[i]);
        }
        return heap;
    }

    public void heapInsert(int[] a, int index, int value) {
        a[index] = value;
        while(index > 0) {
            int parent = (index - 1) / 2;
            if(a[index] < a[parent]) {
                swap(a, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public void adjustHeap(int[] a, int begin, int len) {
        int tmp = a[begin];
        int child ;
        for(;(begin * 2 + 1) < len;begin = child) {
            child = begin * 2 + 1;
            if(child + 1 < len && a[child] > a[child + 1]) child++;
            if(a[child] < tmp) {
                a[begin] = a[child];
            } else {
                break;
            }
        }
        a[begin] = tmp;
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
