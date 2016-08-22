package com.sorting;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by major on 16/5/13.
 */
public class RadixSort {
    public int[] radixSort(int[] A, int n) {
        // write code here
        if(A == null || n < 2) return null;

        int negNum = 0;
        for(int i=0;i<n;i++) {
            if(A[i] < 0)
                negNum++;
        }
        int[] posArr = new int[n - negNum];
        int[] negArr = new int[negNum];
        int posi = 0;
        int negi = 0;
        for(int i=0;i<n;i++) {
            if(A[i] >= 0) {
                posArr[posi++] = A[i];
            } else {
                negArr[negi++] = A[i];
            }
        }
        radixSortForPositive(posArr);
        radixSortForPositive(negArr);
        int index=0;
        for(int i=negNum - 1;i>=0;i--) {
            A[index++] = -negArr[i];
        }
        for(int i=0;i<posArr.length;i++) {
            A[index++] = posArr[i];
        }
        return A;
    }

    public void radixSortForPositive(int[] a) {
        if(a == null || a.length<2) return;
        int max = max(a);
        String maxStr = String.valueOf(max);
        int len = maxStr.length();
        ArrayList<LinkedList<Integer>> qArr1 = new ArrayList<>();
        ArrayList<LinkedList<Integer>> qArr2 = new ArrayList<>();
        for(int i=0;i<10;i++) {
            qArr1.add(new LinkedList<Integer>());
            qArr2.add(new LinkedList<Integer>());
        }
        for(int i=0;i<a.length;i++) {
            qArr1.get(a[i] % 10).offer(a[i]);
        }
        long base = 10;
        for(int j=0;j<len;j++) {
            for(int i=0;i<10;i++) {
                LinkedList<Integer> queue = qArr1.get(i);
                while (! queue.isEmpty()) {
                    int value = queue.poll();
                    qArr2.get((int) (value / base) % 10).offer(value);
                }
            }
            ArrayList<LinkedList<Integer>> tmp = qArr1;
            qArr1 = qArr2;
            qArr2 = tmp;
            base *= 10;
        }
        int index = 0;

        LinkedList<Integer> queue = qArr1.get(0);
        while (! queue.isEmpty()) {
            a[index++] = queue.poll();
        }


    }

    public int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++) {
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }
}
