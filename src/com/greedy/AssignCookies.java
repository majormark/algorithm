package com.greedy;

import java.util.Arrays;

//455. Assign Cookies
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int idx = 0;
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            if (idx >= g.length ) break;
            if (g[idx] <= s[i]) {
                res++;
                idx++;
            }
        }
        return res;
    }
}
