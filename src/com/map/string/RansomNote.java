package com.map.string;

// 383. Ransom Note
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
            return false;
        }
        char[] chr = ransomNote.toCharArray();
        char[] chm = magazine.toCharArray();
        int[] m = new int[26];
        for (int i = 0; i < chm.length; i++) {
            m[chm[i] - 'a']++;
        }
        for (int i = 0; i < chr.length; i++) {
            m[chr[i] - 'a']--;
            if (m[chr[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
