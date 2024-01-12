package com.dp.bagProblem.zeroOne;

public class LastStoneWeight {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int size = sum / 2;
        int[] dp = new int[size + 1];
        for (int i = 0; i < n; i++) {
            for (int j = size; j >= 0; j--) {
                if (j >= stones[i]) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
        }
        return sum - dp[size] - dp[size];
    }
}
