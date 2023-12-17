package com.stackAndQueue;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (!stack.isEmpty() && stack.peek() == ch[i]) {
                stack.pop();
            } else {
                stack.push(ch[i]);
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        char[] res = new char[stack.size()];
        int idx = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[idx--] = stack.pop();
        }
        return new String(res);
    }
}
