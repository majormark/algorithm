package com.string;

public class PointNewChar {
    public String pointNewChar(String s, int k) {
        if (s == null || s.equals("") || k < 0 || k >= s.length()) {
            return "";
        }
        char[] ch = s.toCharArray();
        int idx = k - 1;
        int uNum = 0;
        while (idx >= 0 && !isUpper(ch[idx])) {
            uNum++;
        }
        if (uNum % 2 == 1) {
            return s.substring(k-1, k+1);
        }
        if (isUpper(ch[k])) {
            return s.substring(k, k+2);
        }
        return s.substring(k, k + 1);
    }

    public boolean isUpper(char a) {
        return a >= 'A' && a <= 'Z';
    }
}
