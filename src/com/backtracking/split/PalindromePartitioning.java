package com.backtracking.split;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 131. Palindrome Partitioning
public class PalindromePartitioning {
    List<List<String>> res;
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtracking(s, 0);
        return res;
    }
    public void backtracking(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                continue; // 注意不要写成return，只有终止条件才是return
            }
            String sub = s.substring(start, i + 1);
            path.add(sub);
            backtracking(s, i + 1);
            path.removeLast();
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i <= j ; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PalindromePartitioning().partition("efe");
    }
}
