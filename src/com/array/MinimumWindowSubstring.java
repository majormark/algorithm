package com.array;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring https://leetcode.cn/problems/minimum-window-substring/description/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int left = 0;
        int right = 0;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int len = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < cht.length; i++) {
            tMap.put(cht[i], tMap.getOrDefault(cht[i], 0) + 1);
        }
        for (right = 0; right < chs.length; right++) {
            if (tMap.containsKey(chs[right])) {
                sMap.put(chs[right], sMap.getOrDefault(chs[right], 0) + 1);
            }
            while (sMap.size() == tMap.size() && check(sMap, tMap)) {
                if (tMap.containsKey(chs[left])) {
                    if (len > right - left + 1) {
                        len = right - left + 1;
                        start = left;
                        end = right + 1;
                    }
                    sMap.put(chs[left], sMap.get(chs[left])-1);
                    if (sMap.get(chs[left]) == 0) {
                        sMap.remove(chs[left]);
                    }
                }
                left++;
            }
        }
        return s.substring(start, end);
    }
    public boolean check(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (entry.getValue() < tMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("a", "b"));
    }
}
