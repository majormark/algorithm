package com.dp;

public class LongestCommonSubstring {
    public int[][] getDp(char[] s1, char[] s2) {
        int m = s1.length;
        int n = s2.length;
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++) {
            if (s1[i] == s2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j=0;j<n;j++) {
            if (s1[0] == s2[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp;
    }

    public String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = getDp(ch1, ch2);
        int m = ch1.length;
        int n = ch2.length;
        int max = 0;
        int end = -1;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        if (end >= 0) {
            return str1.substring(end - max + 1, end + 1);
        }
        return "";
    }

    public String lcst2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int end = 0;
        int max = 0;
        int row = 0;
        int col = ch2.length;
        while (row < ch1.length) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < ch1.length && j < ch2.length) {
                if (ch1[i] == ch2[j]) {
                    len++;
                } else {
                    len = 0;
                }
                if (len > max) {
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }
}
