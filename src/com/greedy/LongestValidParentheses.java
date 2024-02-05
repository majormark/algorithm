package com.greedy;

//32. Longest Valid Parentheses
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] ch = s.toCharArray();
        if (ch.length <= 1) return 0;
        int res = 0;
        int l = 0, r = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') l++;
            else r++;
            if (r > l) {
                l = 0;
                r = 0;
            } else if (r == l) {
                res = Math.max(r * 2, res);
            }
        }
        l = r = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == '(') l++;
            else r++;
            if (l > r) {
                l = 0;
                r = 0;
            } else if (r == l) {
                res = Math.max(res, l * 2);
            }
        }
        return res;
    }
}
