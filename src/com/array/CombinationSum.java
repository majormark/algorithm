package com.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 lc 39
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            backtrace(candidates, target, i, res, new LinkedList<>(), 0);
        }
        return res;
    }

    public void backtrace(int[] candidates, int target, int idx, List<List<Integer>> res, List<Integer> preList, int preSum) {
        if (idx >= candidates.length) {
            return;
        }
        preSum += candidates[idx];
        if (preSum > target) {
            return;
        }
        preList.add(candidates[idx]);
        if (preSum == target) {
            res.add(preList);
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] + preSum > target) {
                break;
            }
            backtrace(candidates, target, i, res, new LinkedList<>(preList), preSum);
        }
    }
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2}, 1));
    }
}
