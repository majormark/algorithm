package com.dp.bagProblem.zeroOne;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            int count1 = 0;
            int count0 = 0;
            for (int k = 0; k < ch.length; k++) {
                if (ch[k] == '1') count1++;
                else count0++;
            }
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= count0 && k >= count1) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - count0][k - count1] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
