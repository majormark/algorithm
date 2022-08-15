package com.string;

public class KMP {
    public int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || m.length() > s.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = s.toCharArray();
        int[] nextArr = getNextArray(ms);
        int si = 0;
        int mi = 0;
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[si]) {
                si++;
                mi++;
            } else if (nextArr[mi] == -1) {
                si++;
            }else {
                mi = nextArr[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public int[] getNextArray(char[] ms) {
        if (ms.length  == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < ms.length) {
            if (ms[cn] == ms[pos-1]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
