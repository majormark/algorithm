package com.string;

import java.util.Arrays;

/**
 * 最长回文子串 lc 5
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int[][] dp = getDp(s.toCharArray());
        int row = -1, col = -1;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return s.substring(row, col + 1);
    }

    public int[][] getDp(char[] ch) {
        int len = ch.length;
        int[][] m = new int[len][len];
        for (int i = 0; i < len; i++) {
            m[i][i] = 1;
            if (i > 0 && ch[i-1] == ch[i]) {
                m[i-1][i] = 2;
            }
        }
        for (int j = 2; j < len; j++) {
            for (int i = j - 2; i >= 0; i--) {
                if (ch[i] == ch[j] && m[i+1][j-1] > 0) {
                    m[i][j] = m[i + 1][j - 1] + 2;
                }
            }
        }
        return m;
    }

    public static void main(String[]  args) {
        String s = "aacabdkacaa";

        System.out.println( new LongestPalindromicSubstring().longestPalindrome(s));
        //System.out.println(Arrays.deepToString(new LongestPalindromicSubstring().getDp(s.toCharArray())) );
    }
}
