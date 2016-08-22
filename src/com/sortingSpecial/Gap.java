package com.sortingSpecial;

/**
 * Created by major on 16/6/6.
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 * 测试样例：
 * [1,2,5,4,6],5
 * 返回：2
 */
public class Gap {
    public int maxGap(int[] A, int n) {
        // write code here
        int max = A[0];
        int min = A[0];
        for(int i=1;i<n;i++) {//find the maximum value and the minimum value
            if(A[i] > max) {
                max = A[i];
            } else if(A[i] < min) {
                min = A[i];
            }
        }
        if(min == max)
            return 0;
        boolean[] hasNum = new boolean[n + 1];
        int[] maxs = new int[n + 1];
        int[] mins = new int[n + 1];
        double unit = (max - min) / (double) n;

        for(int i=0;i<n;i++) {//put number into the accordant bucket
            int pos = (int) ((A[i] - min) / unit);
            maxs[pos] = hasNum[pos] ? Math.max(maxs[pos], A[i]) : A[i];
            mins[pos] = hasNum[pos] ? Math.min(mins[pos], A[i]) : A[i];
            hasNum[pos] = true;
        }


        int diff = 0;
        int lastMax = 0;
        int i = 0;
        while (i <= n) {
            if (hasNum[i++]) { // 找到第一个不空的桶
                lastMax = maxs[i - 1];
                break;
            }
        }
        for (; i <= n; i++) {
            if (hasNum[i]) {
                diff = Math.max(diff, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return diff;
    }


}
