package com.backtracking.combination;

import java.util.LinkedList;
import java.util.List;

//22. Generate Parentheses
public class GenerateParentheses {
    public List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        backtrack(0, 0, n, new StringBuilder());
        return res;
    }

    public void backtrack(int left, int right, int n, StringBuilder path) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }
        if (left < n) {
            path.append("(");
            backtrack(left + 1, right, n, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(")");
            backtrack(left, right + 1, n, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
