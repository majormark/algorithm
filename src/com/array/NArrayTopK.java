package com.array;

public class NArrayTopK {
    public int[] printTopK(int[][] m, int k) {
        HeapNode[] heap = new HeapNode[m.length];
        for (int i = 0; i < m.length; i++) {
            heap[i] = new HeapNode(m[i][m[i].length - 1], i, m[i].length - 1);
        }
        for (int i = (heap.length - 1) / 2; i >= 0; i--) {
            heapAdjust(heap, i, heap.length);
        }
        int[] res = new int[k];
        int len = heap.length;
        for (int i = 0; i < k && len > 0; i++) {
            HeapNode top = heap[0];
            res[i] = top.value;
            if (top.index > 0) {
                heap[0] = new HeapNode(m[top.arrNum][top.index - 1], top.arrNum, top.index - 1);
            } else {
                heap[0] = heap[len-1];
                len--;
            }
            heapAdjust(heap, 0, k);
        }
        return res;
    }

    public void heapAdjust(HeapNode[] heap, int index, int length) {
        int child;
        HeapNode tmp = heap[index];
        for (; index < length; index = child) {
            child = index * 2 + 1;
            if (child < length - 1 && heap[child + 1].value > heap[child].value) child++;
            if (heap[child].value > heap[index].value) {
                heap[index] = heap[child];
            } else {
                break;
            }
        }
        heap[index] = tmp;
    }
}

class HeapNode {
    public int arrNum;
    public int value;
    public int index;

    public HeapNode(int value, int arrNum, int index) {
        this.value = value;
        this.arrNum = arrNum;
        this.index = index;
    }
}
