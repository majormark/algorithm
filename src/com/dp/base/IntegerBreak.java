package com.dp.base;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = i / 2; j > 0; j--) {
                int a = Math.max(j, dp[j]);
                int b = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], a * b);
            }
        }
        return dp[n];
    }
}
