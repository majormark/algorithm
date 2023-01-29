package com.string;

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

    public boolean isMatchOld(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        int si = 0;
        int pi = 0;
        char pre = ' ';
        while (si < chs.length && pi < chp.length) {

            if (chp[pi] == '*') {
                if (pre != ' ' && (pre == chs[si] || pre == '.')) {
                    si++;
                } else {
                    pi++;
                }
            } else if (chp[pi] == '.') {
                pre = chp[pi];
                pi++;
                si++;
            } else if (chs[si] == chp[pi]) {
                pre = chp[pi];
                si++;
                pi++;
            } else if (pi < chp.length - 1 && chp[pi + 1] == '*') {
                pi += 2;
            } else {
                return false;
            }
        }
        if (si == chs.length) {
            if (pi == chp.length) {
                return true;
            } else if (pi == chp.length - 1 && (chp[pi] == '*' || chp[pi] == '.')) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aaab", "c*a*b"));
    }
}
