package com.string;

public class SumOfNumSubstring {
    public int numSum(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int res = 0;
        int num = 0;
        int cur = 0;
        boolean posi = true;
        for (int i=0;i<ch.length;i++) {
            cur = ch[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (ch[i] == '-') {
                    if (i > 0 && ch[i-1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        return res;
    }
}
