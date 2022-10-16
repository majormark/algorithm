package com.string;

public class MinLengthOfContainsSubstring {
    public int minLength(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return 0;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int left = 0;
        int right = 0;
        int match = ch2.length;
        int minLength = Integer.MAX_VALUE;
        int[] map = new int[256];
        for (int i = 0; i < ch2.length; i++) {
            map[ch2[i]]++;
        }
        while (right < ch1.length) {
            map[ch1[right]]--;
            if (map[ch1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[ch1[left]] < 0) {
                    map[ch1[left++]]++;
                }
                minLength = Math.min(minLength, right - left + 1);
                match++;
                map[ch1[left++]]++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
