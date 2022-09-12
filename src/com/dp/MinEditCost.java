package com.dp;

public class MinEditCost {
    public int minCost1(String s1, String s2, int ic, int dc, int rc) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int m = ch1.length;
        int n = ch2.length;
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<m+1;i++) {
            dp[i][0] = i * dc;
        }
        for (int j=0;j<n+1;j++) {
            dp[0][j] = j * dc;
        }
        for (int i=1;i<m+1;i++) {
            for (int j=1;j<n+1;j++) {
                dp[i][j] = ch1[i] == ch2[j] ? dp[i-1][j-1] : dp[i-1][j-1] + rc;
                dp[i][j] = Math.min(Math.min(dp[i-1][j] + dc, dp[i][j-1] + ic), dp[i][j]);
            }
        }
        return dp[m][n];
    }

    public int minCost2(String s1, String s2, int ic, int dc, int rc) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] longs = ch1.length >= ch2.length ? ch1 : ch2;
        char[] shorts = ch1.length >= ch2.length ? ch2 : ch1;
        int m = longs.length;
        int n = shorts.length;
        int[] dp = new int[n+1];
        for (int j=0;j<n+1;j++) {
            dp[j] = j * dc;
        }
        int tmp = 0;
        for (int i=1;i<m+1;i++) {
            int leftUp = dp[0];
            dp[0] = i * dc;
            for (int j=1;j<n+1;j++) {
                tmp = dp[j];
                dp[j] = longs[i] == shorts[j] ? leftUp : leftUp + rc;
                dp[j] = Math.min(dp[j], tmp + dc);
                dp[j] = Math.max(dp[j], dp[j-1] + ic);
                leftUp = tmp;
            }
        }
        return dp[n];
    }
}
