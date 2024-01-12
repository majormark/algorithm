package com.dp.bagProblem.zeroOne;

import java.util.Arrays;

public class BagProblem {
    // 0-1背包基础问题
    public static void bagProblem(int[] weight, int[] value, int size) {
        if (weight.length == 0) return;
        int n = weight.length;
        int[][] dp = new int[n][size + 1];

        for (int j = weight[0]; j <= size; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= size; j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // 打印dp数组
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void bagProblem2(int[] weight, int[] value, int size) {
        int[] dp = new int[size + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = size; j >= 0; j--) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
    }
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        bagProblem2(weight,value,bagSize);
    }
}
