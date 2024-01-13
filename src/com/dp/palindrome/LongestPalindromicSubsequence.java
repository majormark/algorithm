package com.dp.palindrome;

//516. Longest Palindromic Subsequence
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (ch[i] == ch[j]) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    if (j - i > 1) dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    else if (j-i == 1) dp[i][j] = 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
