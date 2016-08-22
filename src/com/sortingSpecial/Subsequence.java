package com.sortingSpecial;

/**
 * Created by major on 16/6/3.
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 * 测试样例：
 * [1,4,6,5,9,10],6
 * 返回：2
 */
public class Subsequence {
    public int shortestSubsequence(int[] A, int n) {
        // write code here

        int max = A[0];
        int min = A[n - 1];
        int rightPos = 0;
        int leftPos = n - 1;
        for(int i=1;i<n;i++) {
            if(A[i] < max) {
                rightPos = i;
            } else if(A[i] > max) {
                max = A[i];
            }

        }
        for(int i=n-2;i>=0;i--) {
            if(A[i] > min) {
                leftPos = i;
            } else if(A[i] < min) {
                min = A[i];
            }
        }
        if((leftPos - rightPos) == (n - 1))
            return 0;
        return rightPos - leftPos + 1;
    }
}
