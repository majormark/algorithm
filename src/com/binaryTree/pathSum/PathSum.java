package com.binaryTree.pathSum;

import com.binaryTree.TreeNode;

import java.util.HashMap;

public class PathSum {
    //437. Path Sum III
    HashMap<Long, Integer> map = new HashMap<>();
    int target;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        map.put(0L, 1);
        return process(root, 0);
    }

    public int process(TreeNode node, long preSum) {
        if (node == null) return 0;
        long curSum = preSum + node.val;
        int res = map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        int left = process(node.left, curSum);
        int right = process(node.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
        return res + left + right;
    }
}
