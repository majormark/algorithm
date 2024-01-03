package com.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        int[] used = new int[nums.length];
        backtrack(nums, used);
        return res;
    }

    public void backtrack(int[] arr, int[] used) {
        if (path.size() == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i] == 1) continue;
            path.add(arr[i]);
            used[i] = 1;
            backtrack(arr, used);
            used[i] = 0;
            path.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        backtrack2(nums, used);
        return res;
    }

    public void backtrack2(int[] arr, int[] used) {
        if (path.size() == arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i > 0 && arr[i-1] == arr[i] && arr[i-1] == 0) {
                continue;
            }
            path.add(arr[i]);
            used[i] = 1;
            backtrack2(arr, used);
            path.removeLast();
            used[i] = 0;
        }
    }

}
