package com.map.string;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        HashMap<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < ch1.length; i++) {
            m.put(ch1[i], m.getOrDefault(ch1[i], 0) + 1);
        }
        for (int i = 0; i < ch2.length; i++) {
            m.put(ch2[i], m.getOrDefault(ch2[i], 0) - 1);
            if (m.get(ch2[i]) < 0) {
                return false;
            }
        }
        return true;
    }
}
