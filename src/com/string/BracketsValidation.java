package com.string;

public class BracketsValidation {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '(' && ch[i] != '}') {
                return false;
            }
            if (ch[i] == ')' && --count < 0) {
                return false;
            }
            if (ch[i] == '(') {
                count++;
            }
        }
        return count == 0;
    }
    public int maxLength(String s) {
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length];
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ')' && i - dp[i-1] > 0) {
                int n = i - dp[i-1];
                if (ch[n-1] == '(') {
                    dp[i] = dp[i-1] + 2;
                    if (n - 1 > 0) {
                        dp[i] += dp[n-2];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
