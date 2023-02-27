package com.string;

import java.util.*;

/**
 * 电话号码的字母组合 lc 17
 */
public class LetterCombinationsOfAPhoneNumber {
    Map<Character, String[]> map = new HashMap<Character, String[]>() {{
        put('2', new String[]{"a", "b", "c"});
        put('3', new String[]{"d", "e", "f"});
        put('4', new String[]{"g", "h", "i"});
        put('5', new String[]{"j", "k", "l"});
        put('6', new String[]{"m", "n", "o"});
        put('7', new String[]{"p", "q", "r", "s"});
        put('8', new String[]{"t", "u", "v"});
        put('9', new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }
        Queue<String> q = new LinkedList<>();
        char[] chs = digits.toCharArray();
        int len = 1;
        String[] lt = map.get(chs[0]);

        for (int i = 0; i < lt.length; i++) {
            q.offer((lt[i]));
        }
        while (len < chs.length) {
            lt = map.get(chs[len]);
            while (q.peek().length() < len + 1) {
                String prefix = q.poll();
                for (int i = 0; i < lt.length; i++) {
                    q.offer(prefix + lt[i]);
                }
            }
            len++;
        }
        List<String> res = new LinkedList<>();
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("234"));
    }
}
