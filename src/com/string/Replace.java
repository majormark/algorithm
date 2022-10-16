package com.string;

/**
 * 替换字符串中连续出现的指定字符串
 */
public class Replace {
    public String replace(String s, String f, String t) {
        if (s == null || f == null || s.equals("") || f.equals("")) {
            return s;
        }
        char[] chs = s.toCharArray();
        char[] chf = f.toCharArray();
        char[] cht = t.toCharArray();
        int match = 0;
        for (int i=0;i<chs.length;i++) {
            if (chs[i] == chf[match++]) {
                if (match == chf.length ) {
                    clearCh(chs, i, chf.length);
                    match=0;
                }
            } else {
                if (chs[i] == chf[0]) {
                    i--;
                }
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for (int i=0;i<chs.length;i++) {
            if (chs[i] != 0) {
                cur += String.valueOf(chs[i]);
            }
            if (chs[i] == 0 && (i == 0 || chs[i-1] != 0)) {
                res = res + cur + t;
                cur = "";
            }
        }
        res += cur;
        return res;
    }

    public void clearCh(char[] chs, int end, int len) {
        while (len > 0) {
            chs[end--] = 0;
            len--;
        }
    }
}
