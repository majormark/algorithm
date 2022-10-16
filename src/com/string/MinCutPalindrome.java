package com.string;

public class MinCutPalindrome {
    public int minCut(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int len = ch.length;
        int[] dp = new int[len+1];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        int i = len - 1;
        int j;
        while (i >= 0) {
            j = i;
            while (j < len) {
                if (i == j) {
                    p[i][j] = true;
                } else if (j - i == 1 && ch[i] == ch[j]) {
                    p[i][j] = true;
                } else if (j - i > 1 && ch[i] == ch[j] && p[i+1][j-1]) {
                    p[i][j] = true;
                }
                if (p[i][j]) {
                    dp[i] = Math.min(dp[i], dp[j+1] + 1);
                }
                j++;
            }
            i--;
        }
        return dp[0];
    }
}
