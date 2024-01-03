package com.backtracking.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 77. Combinations
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backTracking(1, n, k, res, new ArrayList<>());
        return res;
    }

    public void backTracking(int start, int n, int k, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n + 1; i++) {
            List<Integer> a = new ArrayList<>(path);
            a.add(i);
            backTracking(i + 1, n, k, res, a);
        }
    }
}
