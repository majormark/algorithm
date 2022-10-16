package com.string;

/**
 * 字符串匹配问题 pg294
 */
public class StringMatch {
    public boolean isValid(char[] str, char[] exp) {
        if (str == null || exp == null || exp.length == 0) {
            return false;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '.' || str[i] == '*') {
                return false;
            }
        }
        if (exp[0] == '*') {
            return false;
        }
        for (int i = 0; i < exp.length - 1; i++) {
            if (exp[i] == '*' && exp[i + 1] == '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch(String str, String exp) {
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        return isValid(s, e) && process(s, e, 0, 0);
    }

    public boolean process(char[] s, char[] e, int si, int ei) {
        if (ei == e.length) {
            return si == s.length;
        }
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            return si != s.length && (s[si] == e[ei] || e[ei] == '.') && process(s, e, si + 1, ei + 1);
        }
        while (si != s.length && (s[si] == e[ei] || e[ei] == '.')) {
            if (process(s, e, si, ei + 2)) {
                return true;
            }
            si++;
        }
        return process(s, e, si, ei + 2);
    }

    // =========================================

    public boolean[][] initDpMap(char[] s, char[] e) {
        int slen = s.length;
        int elen = e.length;
        boolean[][] dp = new boolean[slen + 1][elen + 1];
        dp[slen][elen] = true;
        for (int i = elen - 2; i >= 0; i -= 2) {
            if (e[i] != '*' && e[i + 1] == '*') {
                dp[slen][i] = true;
            } else {
                break;
            }
        }
        if (slen > 0 && elen > 0 && (e[elen - 1] == '.' || s[slen - 1] == e[elen - 1])) {
            dp[slen - 1][elen - 1] = true;
        }
        return dp;
    }

    public boolean isMatchDp(String str, String exp) {
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        int slen = s.length;
        int elen = e.length;
        boolean[][] dp = initDpMap(s, e);
        for (int i = slen - 2; i >= 0; i--) {
            for (int j = elen - 2; j >= 0; j--) {
                if (e[j + 1] != '*') {
                    dp[i][j] = (e[j] == s[i] || e[j] == '.') && dp[i + 1][j + 1];
                } else {
                    int si = i;
                    while (si != s.length && e[j] == s[si] || e[j] == '.') {
                        if (dp[si][j+2]) {
                            dp[i][j] = true;
                            break;
                        }
                        si++;
                    }
                    if (!dp[i][j]) {
                        dp[i][j] = dp[si][j+2];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
