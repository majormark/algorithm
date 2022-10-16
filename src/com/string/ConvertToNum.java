package com.string;

public class ConvertToNum {
    public int convert(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        char[] ch = str.toCharArray();
        boolean posi = ch[0] != '-';
        for (int i = posi ? 0 : 1; i < ch.length; i++) {
            cur = '0' - ch[i];
            if (res < minq) {
                return 0;
            } else if (res == minq && cur < minr) {
                return  0;
            }
            res = res * 10 + cur;
        }
        if (res == Integer.MIN_VALUE && posi)
            return 0;
        return posi ? -res : res;
    }
}
