package com.backtracking.subset;

import java.util.*;

//491. Non-decreasing Subsequences
public class NonDecreasingSubsequences {
    public List<List<Integer>> res ;
    public LinkedList<Integer> path;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] arr, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        Map<Integer, Boolean> used = new HashMap<>();
        for (int i = start; i < arr.length; i++) {
            if ( used.containsKey(arr[i])) continue;
            if (!path.isEmpty() && path.getLast() > arr[i]) continue;
            used.put(arr[i], true);
            path.add(arr[i]);
            backtrack(arr,i+1);
            path.removeLast();
        }
    }
}
