package com.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成 lc 22
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        List<String> res = new LinkedList<>();
        generate("", 1, 0, "(", n, res);
        return res;
    }

    public void generate(String prefix, int lc, int rc, String symbol, int n, List<String> res) {
        if (lc < rc || lc > n) {
            return;
        }
        String newPrefix = prefix + symbol;
        if (lc == n && rc == n) {
            res.add(newPrefix);
            return;
        }
        generate(newPrefix, lc + 1, rc, "(", n, res);
        generate(newPrefix, lc, rc + 1, ")", n, res);
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
