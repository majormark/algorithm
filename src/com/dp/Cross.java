package com.dp;

public class Cross {
    public boolean isCross(String s1, String s2, String aim) {
        if (s1 == null || s2 == null || aim == null) {
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] chaim = aim.toCharArray();
        if (chaim.length != ch1.length + ch2.length) {
            return false;
        }
        int m = ch1.length;
        int n = ch2.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            if (ch1[i - 1] != chaim[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j < n + 1; j++) {
            if (ch1[j - 1] != chaim[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if ((dp[i - 1][j] && ch1[i - 1] == chaim[i + j - 1]) ||
                        (dp[i][j - 1] && ch2[j - 1] == chaim[i + j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }

    public boolean isCross2(String s1, String s2, String aim) {
        if (s1 == null || s2 == null || aim == null) {
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] chaim = aim.toCharArray();
        if (chaim.length != ch1.length + ch2.length) {
            return false;
        }
        char[] longs = ch1.length >= ch2.length ? ch1 : ch2;
        char[] shorts = ch1.length >= ch2.length ? ch2 : ch1;
        int m = longs.length;
        int n = shorts.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j < n + 1; j++) {
            if (shorts[j - 1] != chaim[j - 1]) {
                break;
            }
            dp[j] = true;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[0] = dp[0] && longs[i - 1] == chaim[i - 1];
            for (int j = 1; j < n + 1; j++) {
                dp[j] = false;
                if ((dp[j] && longs[i - 1] == chaim[i + j - 1]) || (dp[j - 1] && shorts[j - 1] == chaim[i + j - 1])) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
