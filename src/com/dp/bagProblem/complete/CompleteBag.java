package com.dp.bagProblem.complete;

import java.util.Arrays;

public class CompleteBag {
    public static void completeBag(int[] weight, int[] value, int size) {
        int[] dp = new int[size + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < size + 1; j++) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
    }

    public static void main(String[] args) {
        completeBag(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4);
    }
}
