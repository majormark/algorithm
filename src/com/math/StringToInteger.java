package com.math;

import java.util.LinkedList;

public class StringToInteger {
    public boolean pos;

    public int myAtoi(String s) {
        pos = true;
        char[] ch = preHandle(s);
        int num1 = Integer.MIN_VALUE / 10;
        int num2 = Integer.MIN_VALUE % 10;

        int res = 0;
        for (int i = 0; i < ch.length; i++) {
            int m = -(ch[i] - '0');
            if (res < num1) return pos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (res == num1 && m < num2) return pos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + m;

        }
        if (pos && res == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return pos ? -res : res;
    }

    public char[] preHandle(String s) {
        LinkedList<Character> res = new LinkedList<>();
        char[] ch = s.toCharArray();
        int i = 0;
        for (; i < ch.length; i++) {
            if (ch[i] != ' ') {
                break;
            }
        }
        if (i >= ch.length) return new char[]{};
        if (ch[i] == '+') {
            i++;
        } else if (ch[i] == '-') {
            i++;
            pos = false;
        }
        for (; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                res.add(ch[i]);
            } else {
                break;
            }
        }
        char[] r = new char[res.size()];
        for (int j = 0; j < res.size(); j++) {
            r[j] = res.get(j);
        }
        return r;
    }

    public static void main(String[] args) {
        new StringToInteger().myAtoi("2147483646");
    }
}
