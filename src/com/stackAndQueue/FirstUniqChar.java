package com.stackAndQueue;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> m = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }
        for (int i=0;i<s.length();i++) {
            if (m.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
