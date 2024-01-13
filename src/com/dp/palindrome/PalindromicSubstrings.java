package com.dp.palindrome;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        boolean[][] dp = new boolean[ch.length][ch.length];
        int res = 0;
        for (int j = 0; j < ch.length; j++) {
            for (int i = j; i >= 0; i--) {
                if (ch[i] == ch[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) res++;
                }
            }
        }
        return res;
    }
    // 双指针，中心扩散
    public int countSubstrings2(String s) {
        int res = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            res += extend(ch, i, i, ch.length);
            res += extend(ch, i, i + 1, ch.length);
        }
        return res;
    }

    public int extend(char[] ch, int i, int j, int n) {
        int res = 0;
        while (i >= 0 && j < n && ch[i] == ch[j]) {
            res++;
            i--;
            j++;
        }
        return res;
    }
}
