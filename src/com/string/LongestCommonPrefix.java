package com.string;

/**
 * 最长公共前缀 lc 14
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String base = strs[0];
        int end = base.length();
        for (int i = 1; i < strs.length; i++) {
            int res = match(base, strs[i], end);
            end = Math.min(end, res);
        }
        return base.substring(0, end);
    }
    public int match(String base, String s, int end) {
        char[] chb = base.toCharArray();
        char[] chs = s.toCharArray();
        int res = 0;
        int max = Math.min(chb.length, chs.length);
        for (int i = 0; i < max; i++) {
            if (chb[i] != chs[i] || res >= end) {
                break;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

}
