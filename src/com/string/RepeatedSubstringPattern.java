package com.string;

//459. Repeated Substring Pattern
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        String t = s.substring(1) + s.substring(0, s.length()-1);
        return t.contains(s);
    }
}
