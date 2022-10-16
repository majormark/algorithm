package com.string;

public class RemoveKZero {
    public String removeKZeros(String s, int k) {
        if (s == null) {
            return null;
        }
        char[] ch = s.toCharArray();
        int start = -1;
        int count = 0;
        for (int i=0;i<ch.length;i++) {
            if (ch[i] == '0') {
                start = start == -1 ? i : start;
                count++;
            } else {
                if (count == k) {
                    while (count > 0) {
                        ch[start++] = 0;
                        count--;
                    }
                }
                start = -1;
                count = 0;
            }
        }
        if (count == k) {
            while (count > 0) {
                ch[start++] = 0;
                count--;
            }
        }
        StringBuilder b =new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != 0) {
                b.append(ch[i]);
            }
        }
        return b.toString();
    }
}
