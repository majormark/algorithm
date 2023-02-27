package com.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};


    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int res = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            int v = symbolValues.get(ch[i]);
            if (i < ch.length - 1 && symbolValues.get(ch[i]) < symbolValues.get(ch[i + 1])) {
                v = -v;
            }
            res += v;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }
}
