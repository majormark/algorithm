package com.string;

/**
 * Created by major on 16/9/26.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 * 测试样例：
 * "aabcb",5
 * 返回：3
 *
 */

public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        if(A.length() <= 1)
            return A.length();
        int len = 1;
        char[] arr = A.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int preLen = 1;
        map.put(arr[0], 0);
        for(int i=1;i<arr.length;i++) {
            Integer prePos = map.get(arr[i]);
            if(prePos != null) {
                if(i - prePos > preLen) {
                    preLen += 1;

                } else {
                    preLen = i - prePos;

                }
                if(preLen > len) {
                    len = preLen;
                }
                map.put(arr[i], i);
            } else {

                map.put(arr[i], i);

                preLen = preLen + 1;
                if(preLen > len) {
                    len = preLen;
                }

            }
        }

        return len;
    }
}
