package com.math;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    HashMap<Integer, String> m = new HashMap<>();
    HashMap<String, Integer> baseM = new HashMap<>();

    public IntegerToRoman() {
        m.put(1, "I");
        m.put(4, "IV");
        m.put(5, "V");
        m.put(9, "IX");
        m.put(10, "X");
        m.put(40, "XL");
        m.put(50, "L");
        m.put(90, "XC");
        m.put(100, "C");
        m.put(400, "CD");
        m.put(500, "D");
        m.put(900, "CM");
        m.put(1000, "M");
        for (Map.Entry<Integer, String> entry : m.entrySet()) {
            baseM.put(entry.getValue(), entry.getKey());
        }
    }

    public String intToRoman(int num) {

        StringBuilder res = new StringBuilder();
        int base = 1;
        int copy = num;
        while (copy > 0) {
            int x = copy % 10;
            x *= base;
            res.insert(0, convert(x));
            copy /= 10;
            base *= 10;
        }
        return res.toString();
    }

    public String convert(int num) {
        StringBuilder b = new StringBuilder();
        int copy = num;
        while (copy > 0) {

            String s = convertOne(copy);
            b.append(s);
            int base = baseM.get(s);
            copy -= base;
        }
        return b.toString();
    }

    public String convertOne(int num) {
        if (m.containsKey(num)) {
            return m.get(num);
        }
        if (num > 1 && num < 4) {
            return "I";
        } else if (num > 5 && num < 9) {
            return "V";
        } else if (num > 10 && num < 40) {
            return "X";
        } else if (num > 40 && num < 50) {
            return "XL";
        } else if (num > 50 && num < 90) {
            return "L";
        } else if (num > 90 && num < 100) {
            return "XC";
        } else if (num > 100 && num < 400) {
            return "C";
        } else if (num > 400 && num < 500) {
            return "CD";

        } else if (num > 500 && num < 900) {
            return "D";
        } else if (num > 900 && num < 1000) {
            return "CM";
        } else {
            return "M";
        }
    }
    public static void main(String[] args) {
        System.out.println( new IntegerToRoman().intToRoman(1994));
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}
