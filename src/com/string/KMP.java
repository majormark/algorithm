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
            } else {
                mi = nextArr[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < ms.length) {
            if (ms[cn] == ms[pos - 1]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }


    public int[] getNextArray2(char[] ch) {
        if (ch.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ch.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int idx = 2;
        while (idx < ch.length) {
            if (ch[idx - 1] == ch[cn]) {
                next[idx++] = ++cn;
            } else if (cn == 0) {
                next[idx++] = 0;
            } else {
                cn = next[cn];
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() < 1 || needle.length() > haystack.length()) {
            return -1;
        }
        char[] chs = haystack.toCharArray();
        char[] chm = needle.toCharArray();
        int[] nextArr = getNextArray2(chm);
        int si = 0;
        int mi = 0;
        while (si < chs.length && mi < chm.length) {
            if (chs[si] == chm[mi]) {
                si++;
                mi++;
            } else if (mi == 0) {
                si++;
            } else {
                mi = nextArr[mi];
            }
        }
        return mi == chm.length ? si - mi : -1;
    }

}
