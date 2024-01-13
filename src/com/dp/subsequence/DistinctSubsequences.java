package com.dp.subsequence;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int m = chs.length;
        int n = cht.length;
        if (n > m) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (chs[i - 1] == cht[j - 1]) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}
