package com.string;

/**
 * Created by major on 16/9/5.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * 测试样例：
 *
 * "abc",3,"bca",3
 *
 * 返回：true
 */
public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        Map<Character, Integer> mapA = statistics(A);
        Map<Character, Integer> mapB = statistics(B);
        for(Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            Character c = entry.getKey();
            Integer numB = mapB.get(c);
            if(numB == null)
                return false;
            if(!numB.equals(entry.getValue()))
                return false;
        }
        return true;
    }

    public Map<Character, Integer> statistics(String str) {
        char[] array = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++) {
            if(map.get(array[i]) == null) {
                map.put(array[i], 0);
            } else {
                Integer num = map.get(array[i]);
                num++;
                map.put(array[i], num);
            }
        }
        return map;
    }

    public boolean isDeformation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[] map = new int[256];
        for (int i=0;i<ch1.length;i++) {
            map[ch1[i]]++;
        }
        for (int i=0;i<ch2.length;i++) {
            if (map[ch2[i]]-- != 0) {
                return false;
            }
        }
        return true;
    }
}
