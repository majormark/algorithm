package com.backtracking.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> res;
    LinkedList<Integer> path;
    // 39. Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    public void backtrack(int[] arr, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            int r = target - arr[i];
            if (r < 0) return;
            path.add(arr[i]);
            backtrack(arr, r, i);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrack2(candidates, target, 0);
        return res;
    }

    public void backtrack2(int[] arr, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > start  && arr[i] == arr[i-1]) continue; // 树层去重
            int r = target - arr[i];
            if (r < 0) return;
            path.add(arr[i]);
            backtrack2(arr, r, i + 1);//树枝去重
            path.removeLast();
        }
    }
    //216. Combination Sum III
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack3(1, k, n, res, new LinkedList<>());
        return res;
    }

    public void backtrack3(int start, int k, int n, List<List<Integer>> res, LinkedList<Integer> path) {
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (n < 0) {
            return;
        }
        for (int i = start; i <= 10 - (k - path.size()) ; i++) {
            path.add(i);
            backtrack3(i + 1, k, n - i, res, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
