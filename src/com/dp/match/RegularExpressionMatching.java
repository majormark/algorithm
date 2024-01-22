package com.dp.match;

/**
 * 正则表达式匹配 lc 10
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        int m = chs.length;
        int n = chp.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (chp[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(chs, chp, i , j-1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(chs, chp, i , j )) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean matches(char[] s, char[] p, int i, int j) {
        if (i == 0) {
            return false;
        }
        return s[i-1] == p[j-1] || p[j-1] == '.';
    }
}
