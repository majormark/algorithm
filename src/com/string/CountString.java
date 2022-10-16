package com.string;

public class CountString {
    public String countString(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        char[] ch = s.toCharArray();
        int count = 0;
        String res = "";
        for (int i = 0; i < ch.length; i++) {
            count++;
            if (i == ch.length - 1 || ch[i+1] != ch[i]) {
                appendStr(res, ch[i], count);
                count = 0;
            }
        }
        return res;
    }

    public String appendStr(String s, char c, int count) {
        if (s.equals("")) {
            return c + "_" + count;
        }
        return s + "_" + c + "_" + count;
    }

    public char getChar(String s, int index) {
        if (s == null || s.equals("")) {
            return 0;
        }
        String[] strList = s.split("_");
        for (int i = 1; i < strList.length; i+=2) {
            int num = Integer.parseInt(strList[i]);
            if (index - num < 0) {
                return strList[i-1].toCharArray()[0];
            }
            index -= num;
        }
        return 0;
    }
}
