package com.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    //113. Path Sum II
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resList = new LinkedList<>();
        process(root, targetSum, 0, resList, new LinkedList<>());
        return resList;
    }

    public void process(TreeNode node, int targetSum, int preSum, List<List<Integer>> resList, List<Integer> path) {
        if (node == null) {
            return;
        }
        int sum = preSum + node.val;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                resList.add(path);
            }
            return;
        }
        process(node.left, targetSum, sum, resList, new ArrayList<>(path));
        process(node.right, targetSum, sum, resList, new ArrayList<>(path));
    }
}
