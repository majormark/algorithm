package com.dp.subsequence;

public class LongestCommonSubsequence {
    public int[][] getDp(char[] s1, char[] s2) {
        int m = s1.length;
        int n = s2.length;
        int[][] dp = new int[m][n];
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;
        for (int i=1;i<m;i++) {
            if (s1[i] == s2[0] || dp[i-1][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for (int j=1;j<n;j++) {
            if (s2[j] == s1[0] || dp[0][j - 1] == 1) {
                dp[0][j] = 1;
            }
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (s1[i] == s2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return dp;
    }

    public String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getDp(chs1, chs2);
        int m = chs1.length;
        int n = chs2.length;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n-1] == dp[m][n]) {
                n--;
            } else if (m > 0 && dp[m-1][n] == dp[m][n]) {
                m--;
            } else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return res.toString();
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[ch1.length + 1][ch2.length + 1];
        for (int i = 1; i < ch1.length + 1; i++) {
            for (int j = 1; j < ch2.length + 1; j++) {
                if (ch1[i-1] == ch2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[ch1.length][ch2.length];
    }
    public int longestCommonSubsequence2(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[] dp = new int[ch2.length + 1];
        for (int i = 1; i < ch1.length + 1; i++) {
            int pre = dp[0];
            for (int j = 1; j < ch2.length + 1; j++) {
                int tmp = dp[j];
                if (ch1[i-1] == ch2[j-1]) dp[j] = pre + 1;
                else dp[j] = Math.max(dp[j-1], dp[j]);
                pre = tmp;
            }
        }
        return dp[ch2.length];
    }
}
