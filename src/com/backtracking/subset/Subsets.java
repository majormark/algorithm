package com.backtracking.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 78. Subsets
public class Subsets {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] arr, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            backtrack(arr, i + 1);
            path.removeLast();
        }
    }

    //90. Subsets II
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        backtrack2(nums, 0);
        return res;
    }
    public void backtrack2(int[] arr, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i-1]) continue;
            path.add(arr[i]);
            backtrack2(arr, i + 1);
            path.removeLast();
        }
    }

}
