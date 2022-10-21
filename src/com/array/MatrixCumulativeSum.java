package com.array;

/**
 * 子矩阵最大累加和问题
 */
public class MatrixCumulativeSum {
    public int getSum(int[][] m) {
        int max = 0;
        for (int i = 0; i < m.length; i++) {
            int[] sum = new int[m[0].length];
            for (int j = i; j < m.length; j++) {
                for (int k = 0; k < m[0].length; k++) {
                    sum[k] += m[j][k];
                }
                max = Math.max(getArrSum(sum), max);
            }
        }
        return max;
    }

    public int getArrSum(int[] arr) {
        int cur = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur > 0) {
                sum = Math.max(sum, cur);
            } else {
                cur = 0;
            }
        }
        return sum;
    }
}
