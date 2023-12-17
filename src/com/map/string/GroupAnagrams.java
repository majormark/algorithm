package com.map.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// 49. Group Anagrams
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> mapList = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] ch = strs[i].toCharArray();
            int[] count = new int[26];
            for (int j = 0; j < ch.length; j++) {
                count[ch[j] - 'a']++;
            }
            for (int j = 0; j < count.length; j++) {
                if (count[j] != 0) {
                    sb.append((char) (j + 'a'));
                    sb.append(count[j]);
                }

            }
            String key = sb.toString();
            List<String> list = mapList.getOrDefault(key, new LinkedList<>());
            list.add(strs[i]);
            mapList.put(key, list);
        }
        return new ArrayList<List<String>>(mapList.values());
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.append((1 + 'a')).toString());
        System.out.println((char) (1 + 'a'));
    }

}
