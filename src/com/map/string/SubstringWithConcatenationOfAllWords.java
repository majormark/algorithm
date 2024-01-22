package com.map.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        int wordNum = words.length;
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            int left = i, right = i, hit = 0;
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (map.containsKey(word)) {
                    int num = tmp.getOrDefault(word, 0) + 1;
                    tmp.put(word, num);
                    hit++;
                    if (num > map.get(word)) {
                        while (map.get(word) < tmp.get(word)) {
                            String firstWord =  s.substring(left, left + wordLen);
                            tmp.put(firstWord, tmp.get(firstWord) - 1);
                            hit--;
                            left += wordLen;
                        }
                    }
                } else {
                    tmp.clear();
                    left = right;
                    hit = 0;
                }
                if (hit == wordNum) {
                    res.add(left);
                    String firstWord = s.substring(left, left + wordLen);
                    tmp.put(firstWord, tmp.get(firstWord) - 1);
                    left += wordLen;
                    hit--;
                }
            }
        }
        return res;
    }
}
