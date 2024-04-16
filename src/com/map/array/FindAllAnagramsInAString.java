package com.map.array;

import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) return res;
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        for (char c : chp) {
            pMap[c - 'a']++;
        }
        for (int i = 0; i < chs.length; i++) {
            sMap[chs[i] - 'a']++;
            if (i < chp.length - 1) continue;
            if (isMatch(sMap, pMap)) {
                res.add(i - chp.length + 1);
            }
            sMap[chs[i - chp.length + 1] - 'a']--;
        }
        return res;
    }
    public boolean isMatch(int[] sMap, int[] pMap) {
        for (int i = 0; i < pMap.length; i++) {
            if (pMap[i] != sMap[i]) return false;
        }
        return true;
    }
}
