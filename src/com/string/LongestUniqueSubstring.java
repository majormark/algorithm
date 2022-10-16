package com.string;

import java.util.HashMap;

public class LongestUniqueSubstring {
    public int getLengthOfLUS(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int start = 0;
        int res = 0;
        int len = 0;
        char[] ch = s.toCharArray();
        int lastIdx = -1;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (indexMap.containsKey(ch[i])) {
                lastIdx = indexMap.get(ch[i]);
                if (lastIdx >= start) {
                    len=1;
                    start = lastIdx+1;
                } else {
                    len++;
                }
            } else {
                len++;
            }
            indexMap.put(ch[i], i);
            res = Math.max(res, len);
        }
        return res;
    }
}
