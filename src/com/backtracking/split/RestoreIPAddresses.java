package com.backtracking.split;

import java.util.LinkedList;
import java.util.List;

// 93. Restore IP Addresses
public class RestoreIPAddresses {
    public List<String> res;
    public LinkedList<String> path;

    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int start) {
        if (start >= s.length()) {
            if (path.size() == 4) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i+1);
            if (sub.startsWith("0") && sub.length() > 1) {
                return;
            }
            int a = Integer.parseInt(sub);
            if (a > 255) {
                return;
            }
            path.add(sub);
            backtracking(s, i + 1);
            path.removeLast();
        }
    }
}
